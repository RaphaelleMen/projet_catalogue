<template>
    <q-page class="row flex flex-center">
      <div class="q-pa-md">
        <q-table
          title="Résultats"
          :rows="articles"
          :columns="columns"
          row-key="name"
        />
      </div>
    </q-page>
  </template>
  
  <script setup>
  import { defineProps } from 'vue';
  
  const props = defineProps({
    articles: {
      type: Array,
      required: true
    }
  });
  
  const columns = [
    {
      name: 'nomArticle',
      required: true,
      label: 'Article',
      align: 'left',
      field: row => row.nomArticle,
      sortable: true
    },
    {
      name: 'nomMagazine',
      required: true,
      label: 'Magazine',
      align: 'left',
      field: row => row.nomMagazine,
      sortable: true
    },
    {
      name: 'nomThematique',
      required: true,
      label: 'Thématique',
      align: 'left',
      field: row => row.nomThematique,
      sortable: true
    },
    {
      name: 'dateMagazine',
      required: true,
      label: 'Date de parution',
      align: 'left',
      field: row => row.dateMagazine,
      sortable: true
    }
  ];
  </script>