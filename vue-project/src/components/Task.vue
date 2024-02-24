<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

function open2() {
  router.push('/taskinfo')
}
</script>

<template>
  <div
    @click="open2"
    class="border-2 border-neutral-800 h-auto pl-3 pt-3 pb-3 rounded-lg bg-teal-300 cursor-pointer"
  >
    <h2 class="text-xl">Задание</h2>
    <p>Описание</p>
  </div>
</template>
