<template>
    <q-page>
        <h4>Maisons d'édition</h4>
        <div>
          <h5>Ajouter une maison d'édition</h5>
          <div class="row justify-around col-8">
            <div class="col-8">
              <q-input outlined bottom-slots v-model="inputNomME" :dense="dense">
                <template v-slot:before>
                  Nom
                </template>
              </q-input>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
              <q-input outlined bottom-slots v-model="inputMagazine" :dense="dense">
                <template v-slot:prepend>
                  <q-icon name="event" />
                </template>
                <template v-slot:before>
                  Date de création
                </template>
              </q-input>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
              <q-input outlined bottom-slots v-model="inputAdresseME" :dense="dense">
                <template v-slot:before>
                  Adresse
                </template>
              </q-input>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
              <q-select class="col-4" outlined v-model="retourThematique" :options="thematiques">
                <template v-slot:before>
                  Thématiques
                </template>
              </q-select>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
              <q-btn :ripple="{ center: true }" color="primary" label="Ajouter une maison d'édition" icon-right="send" class="q-my-xl q-pa-md"/>
            </div>
          </div>
        </div>
        <div>
          <div class="q-pa-md">
            <q-table
              title="Maisons d'édition enregistrées"
              :rows="editions"
              :columns="columns"
              row-key="name"
              :loading="loadingEditions"
            >
              <template v-slot:body-cell-action="props">
                <q-td :props="props">
                  <q-btn
                    color="primary q-mr-md"
                    label="Modifier"
                    @click="editRow(props.row)"
                  />
                  <q-btn
                    color="grey"
                    label="Supprimer"
                    @click="deleteRow(props.row)"
                  />
                </q-td>
              </template>
            </q-table>
          </div>
        </div>
        <q-dialog v-model="dialogEdit">
          <q-card>
            <q-card-section>
              <div class="text-h6">Modifier une Maison d'édition</div>
            </q-card-section>
    
            <q-card-actions align="right">
              <q-form @submit="updateRow">
                <div class="row justify-between">
                  <q-input
                    filled
                    class="q-ma-xs col"
                    v-model="editNom"
                    label="Nom"
                    required
                    dense
                  />
                  <q-input
                    filled
                    class="q-ma-xs col"
                    v-model="editAdresse"
                    label="Adresse"
                    required
                    dense
                  />
                  <q-btn
                  type="submit"
                  color="primary"
                  class="full-width q-mt-md"
                  label="Modifier"
                  dense
                  />
                </div>
              </q-form>
            </q-card-actions>
          </q-card>
        </q-dialog>
    </q-page>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { date } from 'quasar'
import { api } from 'boot/axios';

defineOptions({
  name: 'MaisonEditionPage'
});

const editions = ref([]);
const editId = ref(null);
const editAdresse = ref(null);
const editNom = ref(null);
const editDate = ref(null);

const loadingEditions = ref(false);
const dialogEdit = ref(false);

onMounted(async () => {
  await loadEditionsData();
});

const columns = [
  {
    name: 'nom',
    required: true,
    label: "Maison d'édition",
    align: 'left',
    field: row => row.nom,
    sortable: true
  },
  {
    name: 'adresse',
    required: true,
    label: 'Adresse',
    align: 'left',
    field: row => row.adresse,
    sortable: true
  },
  {
    name: 'dateCreation',
    required: true,
    label: 'Date de création',
    align: 'left',
    field: row => row.dateCreation,
    sortable: true
  },
  {
    name: 'action',
    align: 'center',
    label: 'Action',
    field: 'action',
  },
]

function updateRow() {
  api
    .put('/edition', {
      id: editId.value,
      nom: editNom.value,
      adresse: editAdresse.value,
      dateCreation: editDate.value,
    })
    .then(() => {
      loadEditionsData();
      dialogEdit.value = false;
    });
}

function editRow(row) {
  editId.value = row.id;
  editAdresse.value = row.adresse;
  editNom.value = row.nom;
  editDate.value = row.dateCreation;
  dialogEdit.value = true;
}

async function loadEditionsData() {
  loadingEditions.value = true;
  try {
    const response = await api.get('/editions');
    editions.value = response.data;
  } catch (error) {
    console.log('Erreur :', error);
  } finally {
    loadingEditions.value = false;
  }
}

</script>