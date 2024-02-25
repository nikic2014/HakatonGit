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

    <body class="">
      <div class="p-10 border-t-2 border-b-2 border-gray-200 drop-shadow-md">
        <div class="flex justify-between">
          <h2 class="text-3xl font-bold mb-8 text-cyan-900">Все курсы</h2>
          <button
            @click="toggleAddCourse"
            class="pb-1 px-4 items-center transition bg-cyan-700 w-32 h-8 rounded-xl text-white disabled:bg-slate-300 hover:bg-amber-600 active:bg-cyan-800 cursor-pointer"
          >
            Создать курс
          </button>
        </div>

        <CourseList />
      </div>
    </body>

    <AddCourse id="add" v-if="showAddCourse" @close="toggleAddCourse" />

    <footer class="mt-20 drop-shadow-md"></footer>
  </div>
</template>

<style scoped>
body {
  background-color: rgb(229, 253, 255);
}
</style>
