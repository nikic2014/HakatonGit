<script setup>
import Course from './Course.vue'
const courses = [
  'Курс 1',
  'Курс 2',
  'Курс 3',
  'Курс 4',
  'Курс 5',
  'Курс 6',
  'Курс 7',
  'Курс 8',
  'Курс 9',
  'Курс 10'
]
</script>

<template>
  <div class="grid grid-cols-3 gap-10">
    <Course v-for="(course, index) in courses" :key="index" :title="course" />
  </div>
</template>
