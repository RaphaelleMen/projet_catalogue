<template>
    <q-page>
        <h4>Article</h4>
        <div>
          <h5>Ajouter un article</h5>
          <div class="row justify-around col-8">
            <div class="col-8">
              <q-input outlined bottom-slots v-model="inputTitreArticle" :dense="dense">
                <template v-slot:before>
                  Titre
                </template>
              </q-input>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
                <div class="col-8">
                    <q-input outlined bottom-slots v-model="inputAuteurArticle" :dense="dense">
                      <template v-slot:before>
                        Auteur
                      </template>
                    </q-input>
                  </div>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
                <div class="col-8">
                    <q-input outlined bottom-slots v-model="inputTexteArticle" :dense="dense">
                      <template v-slot:before>
                        Texte
                      </template>
                    </q-input>
                  </div>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
              <q-input outlined bottom-slots v-model="inputImgArticle" :dense="dense">
                <template v-slot:before>
                  Image
                </template>
              </q-input>
            </div>
          </div>
          <div class="row justify-around">
            <div class="col-8">
              <q-btn :ripple="{ center: true }" color="primary" label="Ajouter un article" icon-right="send" class="q-my-xl q-pa-md" @click="addRow()"/>
            </div>
          </div>
        </div>
        <div>
          <div class="q-pa-md">
            <q-table
              title="Articles enregistrés"
              :rows="articles"
              :columns="columns"
              row-key="name"
              :loading="loadingArticles"
            >
              <template v-slot:body-cell-action="props">
                <q-td :props="props">
                  <q-btn
                    color="primary q-mr-md"
                    label="Modifier"
                    @click="editRow(props.row)"
                  />
                  <q-btn
                    color="grey q-mr-md"
                    label="Supprimer"
                    @click="deleteRow(props.row)"
                  />
                  <q-btn
                    color="primary"
                    label="Consulter"
                    @click="getPage(props.row)"
                  />
                </q-td>
              </template>
            </q-table>
          </div>
        </div>
        <q-dialog v-model="dialogEdit">
          <q-card>
            <q-card-section>
              <div class="text-h6">Modifier un article</div>
            </q-card-section>
    
            <q-card-actions align="right">
              <q-form @submit="updateRow">
                <div class="row justify-between">
                  <q-input
                    filled
                    class="q-ma-xs col"
                    v-model="editTitre"
                    label="Titre"
                    required
                    dense
                  />
                  <q-input
                    filled
                    class="q-ma-xs col"
                    v-model="editAuteur"
                    label="Auteur"
                    required
                    dense
                  />
                  <q-input
                    filled
                    class="q-ma-xs col"
                    v-model="editTexte"
                    label="Texte"
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
        <q-dialog v-model="dialogView">
            <q-card>
              <q-card-section>
                <div class="text-h5">Consultation de l'article</div>
              </q-card-section>
              <q-card-section>
                <div class="text-h6">{{ editTitre }}</div>
                <div class="text-subtitle2">par {{ editAuteur }}</div>
              </q-card-section>
              <q-separator dark inset />
              <q-card-section>
                <div class="text-subtitle2">paru dans {{ editFkMagazine }}</div>
                <div class="text-subtitle2">thématiques :  {{ editFkThematique }}</div>
              </q-card-section>
              <q-separator dark inset />
              <q-card-section>
                {{ editTexte }}
                {{ editImg }}
              </q-card-section>
            </q-card>
          </q-dialog>
    </q-page>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { api } from 'boot/axios';

defineOptions({
  name: 'ArticlePage'
});

const inputTitreArticle = ref(null);
const inputAuteurArticle = ref(null);
const inputTexteArticle = ref(null);
const inputImgArticle = ref(null);

const articles = ref([]);

const editId = ref(null);
const editTitre = ref(null);
const editAuteur = ref(null);
const editTexte = ref(null);
const editImg = ref(null);
const editFkMagazine = ref(null);
const editFkThematique = ref(null);

const loadingArticles = ref(false);
const dialogEdit = ref(false);
const dialogView = ref(false);

onMounted(async () => {
  await loadArticlesData();
});

const columns = [
  {
    name: 'titre',
    required: true,
    label: "Titre",
    align: 'left',
    field: row => row.titre,
    sortable: true
  },
  {
    name: 'auteur',
    required: true,
    label: 'Auteur',
    align: 'left',
    field: row => row.auteur,
    sortable: true
  },
  {
    name: 'texte',
    required: true,
    label: 'Texte',
    align: 'left',
    field: row => row.texte,
    sortable: true
  },
  {
    name: 'image',
    required: true,
    label: 'Image',
    align: 'left',
    field: row => row.image,
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
    .put('/article', {
      id: editId.value,
      titre: editTitre.value,
      auteur: editAuteur.value,
      texte: editTexte.value,
      image: editImg.value,
      fkThematique: editFkThematique.value,
      fkMagazine: editFkMagazine.value,
    })
    .then(() => {
      loadArticlesData();
      dialogEdit.value = false;
    });
}

function deleteRow(row) {
  api.delete('/article/' + row.id).then(() => {
    loadArticlesData();
  });
}

function getPage(row) {
    editAuteur.value = row.auteur;
    editTitre.value = row.titre;
    editTexte.value = row.texte;
    editImg.value = row.image;
    editFkMagazine.value = row.fkMagazine;
    editFkThematique.value = row.fkThematique;
    dialogView.value = true;
}

function addRow() {
  api
    .post('/article', {
      titre: inputTitreArticle.value,
      auteur: inputAuteurArticle.value,
      texte: inputTexteArticle.value,
      /*TO DO : Lier aux FK*/
      fkMagazine: 1,
      fkThematique: 1
    })
    .then(() => {
      loadArticlesData();
    });
}

function editRow(row) {
  editId.value = row.id;
  editAuteur.value = row.auteur;
  editTitre.value = row.titre;
  editTexte.value = row.texte;
  editImg.value = row.image;
  editFkMagazine.value = row.fkMagazine;
  editFkThematique.value = row.fkThematique;
  dialogEdit.value = true;
}

async function loadArticlesData() {
  loadingArticles.value = true;
  try {
    const response = await api.get('/articles');
    articles.value = response.data;
  } catch (error) {
    console.log('Erreur :', error);
  } finally {
    loadingArticles.value = false;
  }
}

</script>