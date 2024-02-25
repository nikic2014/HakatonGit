<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

function open(title) {
  router.push({ path: '/courseinfo', query: { title: title } })
}

defineProps({
  title: String
})
</script>

<template>
  <div @click="open(title)" class="course-card">
    <h2 class="mt-2 text-white text-3xl font-bold">{{ title }}</h2>

    <div class="flex justify-between mt-5 text-white">
      <div class="flex flex-col">
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam consequuntur, unde soluta
          deserunt vel officiis quasi, a ipsum veritatis nemo at enim incidunt amet laborum eos
          quibusdam nobis alias voluptatibus?
        </p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.course-card {
  position: relative;
  height: 300px;
  width: 460px;
  background-color: rgb(8 145 178);
  border: 1px solid #d1d5db;
  border-radius: 1.5rem;
  padding: 2rem;
  cursor: pointer;
  transition: 0.1s;
}

.course-card:hover {
  transform: translateY(-3px);
  background-color: rgb(209, 137, 12);
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1);
}

.course-card:active {
  background-color: rgb(217 119 6);
}
</style>
