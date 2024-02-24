<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

function open() {
  router.push('/courseinfo')
}
</script>

<template>
  <div
    @click="open"
    class="relative h-64 w-96 border bg-teal-700 borser-slate-100 rounded-3xl p-8 cursor-pointer hover:-translate-y-2 hover:shadow-xl transition"
  >
    <h2 class="mt-2 text-white">Course</h2>

    <div class="flex justify-between mt-5 text-white">
      <div class="flex flex-col">
        <p>description</p>
      </div>
    </div>
  </div>
</template>

<script></script>
