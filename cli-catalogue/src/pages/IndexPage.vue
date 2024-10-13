<template>
  <q-page class="row flex flex-center">
    <div class="q-pa-md">
      <h1 class="col-12">Recherche</h1>
      <div class="justify-center q-my-xl">
        <div class="col">
          <q-input class="col-4" v-model="inputMagazine" label="Magazine" stack-label :dense="dense" />
          <q-select
            class="col-4"
            outlined
            v-model="retourThematique"
            :options="thematiques"
            option-label="nom"
            option-value="id"
            label="Thématiques"
            :loading="loadingThematiques"
            emit-value
          />
        </div>
        <!-- <div class="q-pa-md">
          <div class="q-pb-sm">Date(s) de publication :</div>
          <q-date v-model="selectDatePubli" range />
        </div> -->
        <q-btn :ripple="{ center: true }" align="around" color="primary" label="Rechercher" @click="loadArticlesData" />
      </div>
      <tableau-accueil :articles="articles" />
    </div>
  </q-page>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import TableauAccueil from 'components/TableauAccueil.vue';
import { date } from 'quasar';
import { api } from 'boot/axios';

defineOptions({
  name: 'IndexPage',
});

const inputMagazine = ref(null);
const retourThematique = ref(null);
const selectDatePubli = ref(null);
const articles = ref([]);

const thematiques = ref([]);
const loadingThematiques = ref(false);

onMounted(async () => {
  await loadThematiques();
  await loadArticlesData();
});

async function loadThematiques() {
  loadingThematiques.value = true;
  try {
    const response = await api.get('/thematiques');
    thematiques.value = response.data;
  } catch (error) {
    console.error('Erreur lors de la récupération des thématiques:', error);
  } finally {
    loadingThematiques.value = false;
  }
}
async function loadArticlesData() {
  try {
    const response = await api.get('/allMagazines', {
      params: {
        nomMagazine: inputMagazine.value,
        fkThematique: retourThematique.value,
        dateMagazine: selectDatePubli.value,
      },
    });
    articles.value = response.data;
  } catch (error) {
    console.log('Erreur :', error);
  }
}
</script>