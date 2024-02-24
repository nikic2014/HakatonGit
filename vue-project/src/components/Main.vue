<script setup>
import { ref } from 'vue'
import CourseList from './CourseList.vue'
import AddCourse from './AddCourse.vue'

var showAddCourse = ref(false)

const toggleAddCourse = () => {
  showAddCourse.value = true
}
</script>

<template>
  <div class="">
    <header
      class="flex items-center gap-4 ml-8 mr-8 mt-2 justify-between border-b-2 border-black h-12"
    >
      <h2 class="text-xl font-bold">GitCourse</h2>
      <p>Username</p>
    </header>

    <body>
      <div class="p-10">
        <div class="flex justify-between">
          <h2 class="text-3xl font-bold mb-8">Все курсы</h2>
          <button
            @click="toggleAddCourse"
            class="pb-1 px-4 items-center transition bg-lime-500 w-32 h-8 rounded-xl text-white disabled:bg-slate-300 hover:bg-lime-600 active:bg-lime-700 cursor-pointer"
          >
            Создать курс
          </button>
        </div>
        <CourseList />
      </div>
    </body>

    <AddCourse v-if="showAddCourse" />
  </div>
</template>

<style scoped>
body {
  background-color: #f0f0f0; /* Замените этот цвет на нужный вам */
}
</style>
