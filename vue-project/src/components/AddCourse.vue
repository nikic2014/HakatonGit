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
    >
      <button
        @click="closeAddCourse"
        class="absolute top-2 right-2 text-amber-800 hover:text-amber-900 focus:outline-none"
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
      <h3 class="text-2xl font-bold text-center mb-4 text-amber-800">Создать курс</h3>
      <form @submit.prevent="closeAddCourse">
        <div class="mb-3">
          <input
            type="text"
            id="courseName"
            name="courseName"
            class="mt-3 pl-3 pr-3 pt-2 pb-2 border border-gray-300 rounded-lg w-80 outline-amber-600"
            placeholder="Название курса"
          />
        </div>
        <div class="mb-5">
          <textarea
            id="courseDescription"
            name="courseDescription"
            class="pl-3 pr-3 pt-2 pb-2 border border-gray-300 rounded-lg w-full outline-amber-600 resize-none"
            placeholder="Описание курса"
          ></textarea>
        </div>
        <div class="flex justify-center">
          <button
            type="submit"
            class="px-4 py-2 bg-amber-600 text-white rounded-md hover:bg-amber-700 active:bg-amber-800 transition-all"
          >
            Создать
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped></style>
