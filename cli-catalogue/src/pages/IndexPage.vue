<template>
  <q-page class="row flex flex-center">
    <div class="q-pa-md">
      <h1 class="col-12">Recherche</h1>
      <div class="justify-center q-my-xl">
        <div class="col">
          <q-input class="col-4" v-model="inputMagazine" label="Magazine" stack-label :dense="dense" />
          <q-select class="col-4" outlined v-model="retourThematique" :options="thematiques" label="Thématiques" />
        </div>
        <div class="q-pa-md">
          <div class="q-pb-sm">
            Date(s) de publication :
          </div>
        
          <q-date v-model="selectDatePubli" range />
        </div>
        <q-btn :ripple="{ center: true }" align="around" color="primary" label="Rechercher" />
      </div>
      <tableau-accueil />
    </div>
  </q-page>
</template>

<script setup>

import { ref } from 'vue';
import TableauAccueil from 'components/TableauAccueil.vue'
import { date } from 'quasar'
import { api } from 'boot/axios'

defineOptions({
  name: 'IndexPage'
});

const inputMagazine = ref(null);
const retourThematique = ref(null);

const selectDatePubli = ref(null)

const timeStamp = Date.now()
const todayDate = date.formatDate(timeStamp, 'YYYY-MM-DD')

const thematiques = [
  {id: 1, label:"nature"},
  {id: 2, label:"chasse"},
  {id: 3, label:"pêche"}
]

async function loadData() {
  try {
    const response = await api.get('/allMagazines', {
      params: {
        nomMagazine: inputMagazine.value,
        fkThematique: idService.value,
        dateMagazine: idSite.value,
      },
    });
    data.value = response.data;
    dataLoaded.value = true;
    pageLoaded.value = true;
  } catch (error) {
    console.log('Erreur :', error);
  }
}

</script>
