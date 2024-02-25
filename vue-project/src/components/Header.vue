<script setup>
import { useRouter } from 'vue-router'
import { ref } from 'vue'

const showLogoutButton = ref(false)
const router = useRouter()

function back2() {
  router.push('/main')
}

function toggleLogoutButton() {
  showLogoutButton.value = !showLogoutButton.value
}

function logout() {
  router.push('/')
}
</script>

<template>
  <div class="">
    <header class="flex justify-between ml-8 mr-8 mt-5 mb-5">
      <div class="flex items-center">
        <h2
          @click="back2"
          class="text-xl font-bold cursor-pointer transition-all text-cyan-950 hover:text-cyan-600"
        >
          GitCourse
        </h2>
      </div>

      <div class="flex items-center">
        <p class="user" @click="toggleLogoutButton">pa3etka</p>
        <button v-if="showLogoutButton" @click="logout" class="logout-button">Выйти</button>
      </div>
    </header>
  </div>
</template>

<style skoped>
.user {
  cursor: pointer;
  font-weight: normal;
  transition: font-weight 0.1s ease;
}
.user:hover {
  font-weight: bold;
}

.logout-button {
  background-color: #dc2626;
  color: #ffffff;
  border-radius: 0.75rem;
  margin-left: 1rem;
  padding-left: 0.75rem;
  padding-right: 0.75rem;
  padding-top: 0.25rem;
  padding-bottom: 0.25rem;
  transition:
    height 1s ease,
    opacity 1s ease;
}

.logout-button:hover {
  background-color: #c82323;
}

.logout-button:active {
  background-color: #bb2020;
}

.show {
  opacity: 1;
  height: auto;
}
</style>
