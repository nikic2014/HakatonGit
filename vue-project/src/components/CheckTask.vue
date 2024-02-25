<script setup>
import { defineEmits } from 'vue'

const emits = defineEmits(['close'])

function closeAddCourse() {
  emits('close')
}

function redirectToGithub() {
  window.location.href = 'https://github.com/nikic2014/HakatonGit'
}

function rateSubmission(event) {
  const rating = prompt('Введите оценку (от 0 до 100):')
  if (rating !== null) {
    const parsedRating = parseInt(rating)
    if (!isNaN(parsedRating) && parsedRating >= 0 && parsedRating <= 100) {
      event.target.parentElement.children[4].textContent = parsedRating
      const statusCell = event.target.parentElement.children[2]
      statusCell.textContent = '03.03.2024'
      statusCell.classList.remove('text-red-600')
    } else {
      alert('Пожалуйста, введите корректное число от 0 до 100.')
    }
  }
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
      <h3 class="text-2xl font-bold text-center mb-4 text-cayn-800">Оценить</h3>
      <form class="tablll">
        <table class="w-full">
          <thead>
            <tr>
              <th>Сслыка на github</th>
              <th>Состояние</th>
              <th>Дата оценки</th>
              <th>Дата сдачи</th>
              <th>Оценка</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td @click="redirectToGithub" class="cursor-pointer hover:text-cyan-500">
                https://github.com/pa3etka/...
              </td>
              <td>Отправлено</td>
              <td>03.03.2024</td>
              <td>01.03.2024</td>
              <td @click="rateSubmission($event)" class="cursor-pointer hover:text-cyan-500">53</td>
            </tr>
            <tr>
              <td @click="redirectToGithub" class="cursor-pointer hover:text-cyan-500">
                https://github.com/pa3etka/...
              </td>
              <td>Не отправлено</td>
              <td>-</td>
              <td>-</td>
              <td>-</td>
            </tr>
            <tr>
              <td @click="redirectToGithub" class="cursor-pointer hover:text-cyan-500">
                https://github.com/pa3etka/...
              </td>
              <td>Отправлено</td>
              <td class="text-red-600">Не оценено</td>
              <td>02.03.2024</td>
              <td class="hover:text-cyan-500 cursor-pointer" @click="rateSubmission($event)">
                Оценить
              </td>
            </tr>
            <tr>
              <td @click="redirectToGithub" class="cursor-pointer hover:text-cyan-500">
                https://github.com/pa3etka/...
              </td>
              <td>Не отправлено</td>
              <td>-</td>
              <td>-</td>
              <td>-</td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>
</template>

<style scoped>
.tablll {
  width: 1300px;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th,
td {
  border: 1px solid #ccc; /* добавляем границу толщиной 1px и цвета #ccc */
  padding: 8px; /* добавляем отступ вокруг содержимого ячейки */
}

th {
  background-color: #f2f2f2; /* добавляем серый фон для заголовков */
}

tr:nth-child(even) {
  background-color: #f9f9f9; /* добавляем светло-серый фон для четных строк */
}
</style>
