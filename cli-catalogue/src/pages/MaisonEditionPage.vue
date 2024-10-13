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
              :rows="rows"
              :columns="columns"
              row-key="name"
            />
          </div>
        </div>
    </q-page>
</template>

<script setup>
import { ref } from 'vue';
import { date } from 'quasar'

defineOptions({
  name: 'MaisonEditionPage'
});

const columns = [
  {
    name: 'name',
    required: true,
    label: "Maison d'édition",
    align: 'left',
    field: row => row.name,
    format: val => `${val}`,
    sortable: true
  },
  { name: 'adresse', align: 'center', label: 'Adresse', field: 'adresse', sortable: true },
  { name: 'thematique', label: 'Thématique', field: 'thematique', sortable: true },
  { name: 'date', label: 'Date de création', field: 'date' }
]

const rows = [
  {
    name: 'maison',
    adresse: 'champ texte',
    thematique: 'Nature',
    date: "12/01/2024"
  },
  {
    name: 'maison',
    adresse: 'champ texte',
    thematique: 'Nature',
    date: "12/01/2024"
  },]
</script>