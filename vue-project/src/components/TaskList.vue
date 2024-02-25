<script setup>
import Task from './Task.vue'
const tasks = [
  'Задание 1',
  'Задание 2',
  'Задание 3',
  'Задание 4',
  'Задание 5',
  'Задание 6',
  'Задание 7',
  'Задание 8',
  'Задание 9',
  'Задание 10'
]
</script>

<template>
  <div class="grid grid-cols-1 gap-5">
    <Task v-for="(task, index) in tasks" :key="index" :titleTask="task" />
  </div>
</template>
