<template>
    <q-page class="row flex flex-center">
        <div class="q-pa-md">
            <q-table
              title="Résultats"
              :rows="rows"
              :columns="columns"
              row-key="name"
            />
          </div>
      </q-page>
</template>

<script setup>
defineOptions({
  name: 'TableauAccueil'
})

const columns = [
  {
    name: 'name',
    required: true,
    label: 'Article',
    align: 'left',
    field: row => row.name,
    format: val => `${val}`,
    sortable: true
  },
  { name: 'magazine', align: 'center', label: 'Magazine', field: 'magazine', sortable: true },
  { name: 'thematique', label: 'Thématique', field: 'thematique', sortable: true },
  { name: 'date', label: 'Date de parution', field: 'date' }
]

const rows = [
  {
    name: 'Titre 1',
    magazine: 'Magazine 1',
    thematique: 'Nature',
    date: "12/01/2024"
  },
  {
    name: 'Titre 1',
    magazine: 'Magazine 1',
    thematique: 'Nature',
    date: "12/01/2024"
  },
  {
    name: 'Titre 1',
    magazine: 'Magazine 1',
    thematique: 'Nature',
    date: "12/01/2024"
  },
  {
    name: 'Titre 1',
    magazine: 'Magazine 1',
    thematique: 'Nature',
    date: "12/01/2024"
  },
  {
    name: 'Titre 1',
    magazine: 'Magazine 1',
    thematique: 'Nature',
    date: "12/01/2024"
  },
  {
    name: 'Titre 1',
    magazine: 'Magazine 1',
    thematique: 'Nature',
    date: "12/01/2024"
  },
  {
    name: 'Titre 2',
    magazine: 'Magazine 2',
    thematique: 'Nature',
    date: "12/01/2024"
  },
  {
    name: 'Titre 2',
    magazine: 'Magazine 1',
    thematique: 'Nature',
    date: "12/01/2024"
  },
  {
    name: 'Titre 28',
    magazine: 'Magazine 1',
    thematique: 'Nature',
    date: "12/01/2024"
  },
  {
    name: 'Titre 1',
    magazine: 'Magazine 1',
    thematique: 'Nature',
    date: "12/01/2024"
  },
]
</script>