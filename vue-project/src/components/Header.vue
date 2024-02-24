<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

function back2() {
  router.push('/main')
}
</script>

<template>
  <header class="flex items-center gap-4 ml-8 mr-8 mt-2 justify-between h-12">
    <h2 @click="back2" class="text-xl font-bold">GitCourse</h2>
    <p>Username</p>
  </header>
</template>
