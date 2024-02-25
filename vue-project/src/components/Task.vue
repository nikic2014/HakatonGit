<script setup>
import { useRouter, useRoute } from 'vue-router'

const route = useRoute()
const router = useRouter()

const title = route.query.title

function open2(title, titleTask) {
  router.push({ path: '/taskinfo', query: { title: title, titleTask: titleTask } })
}

defineProps({
  titleTask: String
})
</script>

<template>
  <div @click="open2(title, titleTask)" class="task">
    <h2 class="text-2xl font-medium mb-2">{{ titleTask }}</h2>
    <p>
      Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam repellendus cupiditate nisi,
      dolorem itaque reprehenderit voluptatum, amet optio voluptate rerum cum nam tenetur adipisci
      mollitia eligendi eius nihil dolores? Quia, dolor inventore minus consectetur perferendis,
      voluptas facilis at aliquam ducimus, eius itaque minima. Fugiat, eaque, minima blanditiis,
      magni ipsa perferendis iure velit assumenda minus suscipit deserunt veniam saepe! Excepturi
      iusto harum quia dolorum sit culpa dolore eveniet, consequuntur neque alias nemo
      exercitationem, itaque repellat suscipit? Nulla, quibusdam ullam! Quis est totam tempore
      officiis qui voluptas exercitationem adipisci dolores quibusdam laborum, culpa debitis sint
      eos vel voluptatem fuga voluptatum omnis saepe.
    </p>
  </div>
</template>

<style scoped>
.task {
  width: 100%;
  height: 185px;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 10px;
  padding-bottom: 150px;
  border-radius: 10px;
  background-color: rgb(8 145 178);
  cursor: pointer;
  color: white;
  transition: 0.1s;
}

.task:hover {
  transform: translateY(-3px);
  background-color: rgb(209, 137, 12);
}

.task:active {
  background-color: rgb(217 119 6);
}
</style>
