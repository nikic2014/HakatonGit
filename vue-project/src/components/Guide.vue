<script setup>
import { defineEmits } from 'vue'

const emits = defineEmits(['close'])

function closeAddCourse() {
  emits('close')
}
</script>

<template>
  <div>
    <div class="fixed top-0 left-0 h-full w-full bg-black z-10 opacity-60"></div>
    <div
      class="fixed top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 bg-white p-8 rounded-md shadow-lg z-20"
      style="max-height: 80vh; overflow-y: auto"
    >
      <button
        @click="closeAddCourse"
        class="absolute top-2 right-2 text-cyan-800 hover:text-cyan-900 focus:outline-none"
      >
        <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M6 18L18 6M6 6l12 12"
          ></path>
        </svg>
      </button>
      <h3 class="text-2xl font-bold text-center mb-4 text-cayn-800">
        Гайд по загрузке решений на платформу
      </h3>

      <form action="">
        <!-- описание -->
        <div class="mb-2 pl-3 pr-3 pt-2 pb-2 border-2 border-cyan-600 rounded-lg w-full">
          Для того чтобы начат работу над заданием примите приглашение на колоборацию к репозиторрию
          курса Для того чтобы сдать финальную версию решения создайте ветку с названием
          task_№Задания На сайте отобразится дата последнего коммита для этого задания
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped></style>
