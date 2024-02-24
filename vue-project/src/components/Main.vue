<script setup>
import { ref } from 'vue'
import CourseList from './CourseList.vue'
import AddCourse from './AddCourse.vue'
import Header from './Header.vue'

var showAddCourse = ref(false)

function toggleAddCourse() {
  showAddCourse.value = !showAddCourse.value
}
</script>

<template>
  <div class="">
    <Header />

    <body class="border-b-2 border-black">
      <div class="p-10">
        <div class="flex justify-between">
          <h2 class="text-3xl font-bold mb-8">Все курсы</h2>
          <button
            @click="toggleAddCourse"
            class="pb-1 px-4 items-center transition bg-teal-700 w-32 h-8 rounded-xl text-white disabled:bg-slate-300 hover:bg-teal-600 active:bg-teal-500 cursor-pointer"
          >
            Создать курс
          </button>
        </div>
        <CourseList />
      </div>
    </body>

    <AddCourse v-if="showAddCourse" />

    <footer class="mt-20"></footer>
  </div>
</template>

<style scoped>
body {
  background-color: #f0f0f0; /* Замените этот цвет на нужный вам */
}
</style>
