<template>
    <q-page>
        <h4>Magazine</h4>
        <div>
          <h5>Ajouter un Magazine</h5>
          <div class="row justify-around col-8">
            <div class="col-8">
              <q-input outlined bottom-slots v-model="inputNomMagazine" :dense="dense">
                <template v-slot:before>
                  Nom
                </template>
              </q-input>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
              <q-input filled v-model="inputDateMagazine" mask="####-##-##">
                <template v-slot:append>
                  <q-icon name="event" class="cursor-pointer">
                    <q-popup-proxy cover transition-show="scale" transition-hide="scale">
                      <q-date v-model="inputDateMagazine">
                        <div class="row items-center justify-end">
                          <q-btn v-close-popup label="Close" color="primary" flat />
                        </div>
                      </q-date>
                    </q-popup-proxy>
                  </q-icon>
                </template>
                <template v-slot:before>
                  Date de publication
                </template>
              </q-input>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
              <q-input outlined bottom-slots v-model="inputNumeroMagazine" :dense="dense">
                <template v-slot:before>
                  Numéro
                </template>
              </q-input>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
              <q-btn :ripple="{ center: true }" color="primary" label="Ajouter un magazine" icon-right="send" class="q-my-xl q-pa-md" @click="addRow()"/>
            </div>
          </div>
        </div>
        <div>
          <div class="q-pa-md">
            <q-table
              title="Magazines enregistrées"
              :rows="magazines"
              :columns="columns"
              row-key="name"
              :loading="loadingMagazines"
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
              <div class="text-h6">Modifier un Magazine</div>
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
                    v-model="editNumero"
                    label="Numero"
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
  name: 'MagazinePage'
});

const inputDateMagazine = ref(null);
const inputNomMagazine = ref(null);
const inputNumeroMagazine = ref(null);

const magazines = ref([]);

const editId = ref(null);
const editNumero = ref(null);
const editNom = ref(null);
const editDate = ref(null);
const editFkEdition = ref(null);

const loadingMagazines = ref(false);
const dialogEdit = ref(false);

onMounted(async () => {
  await loadMagazinesData();
});

const columns = [
  {
    name: 'nom',
    required: true,
    label: "Nom du Magazine",
    align: 'left',
    field: row => row.nom,
    sortable: true
  },
  {
    name: 'numero',
    required: true,
    label: 'Numéro',
    align: 'left',
    field: row => row.numero,
    sortable: true
  },
  {
    name: 'publication',
    required: true,
    label: 'Date de publication',
    align: 'left',
    field: row => row.publication,
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
    .put('/magazine', {
      id: editId.value,
      nom: editNom.value,
      numero: editNumero.value,
      publication: editDate.value,
      fkEdition: editFkEdition.value,
    })
    .then(() => {
      loadMagazinesData();
      dialogEdit.value = false;
    });
}

function deleteRow(row) {
  api.delete('/magazine/' + row.id).then(() => {
    loadMagazinesData();
  });
}

function addRow() {
  api
    .post('/magazine', {
      nom: inputNomMagazine.value,
      numero: inputNumeroMagazine.value,
      publication: inputDateMagazine.value,
      /*TO DO : Lier aux FK*/
      fkEdition: 1
    })
    .then(() => {
      loadMagazinesData();
    });
}

function editRow(row) {
  editId.value = row.id;
  editNumero.value = row.numero;
  editNom.value = row.nom;
  editDate.value = row.publication;
  editFkEdition.value = row.fkEdition;
  dialogEdit.value = true;
}

async function loadMagazinesData() {
  loadingMagazines.value = true;
  try {
    const response = await api.get('/magazines');
    magazines.value = response.data;
  } catch (error) {
    console.log('Erreur :', error);
  } finally {
    loadingMagazines.value = false;
  }
}

</script>