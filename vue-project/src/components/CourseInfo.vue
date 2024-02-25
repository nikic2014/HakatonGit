<script setup>
import { ref } from 'vue'
import { useRoute } from 'vue-router'
import Header from './Header.vue'
import TaskList from './TaskList.vue'
import Guide from './Guide.vue'

var showAddCourse2 = ref(false)

function toggleAddCourse2() {
  showAddCourse2.value = !showAddCourse2.value
}

const route = useRoute()
const title = route.query.title
</script>

<template>
  <div>
    <Header />

    <body>
      <div class="border-t-2 border-gray-200 drop-shadow-md p-10">
        <div class="flex justify-between">
          <h2 class="text-3xl font-bold mb-8 text-cyan-900">{{ title }}</h2>
          <button
            @click="toggleAddCourse2"
            class="pb-1 px-4 items-center transition bg-cyan-700 w-38 h-8 rounded-xl text-white disabled:bg-slate-300 hover:bg-amber-600 active:bg-cyan-800 cursor-pointer"
          >
            Гайд по загрузке
          </button>
        </div>
        <TaskList />
      </div>
    </body>

    <Guide id="add" v-if="showAddCourse2" @close="toggleAddCourse2" />
  </div>
</template>

<style scoped>
body {
  background-color: rgb(229, 253, 255);
}
</style>
