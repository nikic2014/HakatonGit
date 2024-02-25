<script setup>
import { useRouter, useRoute } from 'vue-router'
import Header from './Header.vue'

const router = useRouter()
const route = useRoute()

const title = route.query.title
const titleTask = route.query.titleTask

function back(title) {
  router.push({ path: '/courseinfo', query: { title: title } })
}
</script>

<template>
  <div>
    <Header />

    <body class="p-10 border-t-2 border-gray-200 drop-shadow-md">
      <div class="flex text-cyan-900">
        <h2
          @click="back(title)"
          class="text-3xl font-bold mb-8 cursor-pointer mr-2 hover:text-cyan-600 active:text-cyan-500 transition-all"
        >
          {{ title }}
        </h2>
        <h2 class="text-3xl font-bold mb-8">/</h2>
        <h2 class="text-3xl font-bold mb-8 ml-2">{{ titleTask }}</h2>
      </div>

      <div class="border-2 border-cyan-800 bg-gray-100 rounded-lg h-auto">
        <h2 class="text-2xl mb-5 mr-5 ml-5 mt-5 font-medium text-cyan-900">Условие задания</h2>
        <p class="mb-3 mr-5 ml-5">
          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Sapiente repudiandae ullam,
          corporis dolore autem, accusantium facere, quisquam magnam doloribus ex velit repellat!
          Aperiam id voluptatum magni sunt molestias delectus labore! Dignissimos eligendi est quas
          libero facilis reiciendis? Error unde optio, sit ducimus corrupti quis fugiat ratione
          excepturi quaerat neque ut nobis aspernatur, necessitatibus quos quibusdam eum aperiam
          obcaecati tenetur maxime, accusantium fugit quod aliquid delectus. Atque, reprehenderit
          odio? Consequuntur explicabo asperiores beatae assumenda placeat ducimus exercitationem
          animi itaque porro a minima voluptate dolor vel rem voluptates, ipsa aliquid veritatis
          commodi cum accusantium totam. Illo dolor sint pariatur cumque! Dolores, facilis? Sunt
          earum eaque obcaecati vitae vel ratione minima, odio, error tenetur voluptate
          exercitationem. Perferendis tenetur esse sed, ea enim, exercitationem voluptates fuga
          cupiditate deleniti distinctio vitae aliquam quasi quisquam ut nihil hic dolor quas
          nostrum libero sapiente nisi similique. Unde suscipit ut doloribus, repellendus non totam
          expedita officia dolorum dolorem fugiat hic, quia vitae deleniti architecto consectetur
          provident tempora amet! Quaerat itaque corrupti consequuntur impedit, fuga necessitatibus,
          inventore dicta veritatis fugiat doloribus, sint adipisci temporibus nisi eligendi error?
          Nulla quibusdam aliquid perspiciatis deleniti omnis placeat dolorum qui illo eius quaerat
          error, animi, odit accusamus voluptatum! Iure, accusamus doloremque. Ducimus sint nam
          cupiditate magnam eos ea itaque, aspernatur quo tempore provident totam ipsa dolore
          eveniet ipsam consequatur qui facere magni fugiat aperiam laborum non id vel minima. Id
          itaque a cum quis possimus alias distinctio repellat earum fugiat tempore soluta sapiente
          doloribus reprehenderit, totam magnam laudantium blanditiis maiores inventore non, beatae
          ullam quibusdam minus! Soluta minima molestiae eum. Provident iusto, est culpa sapiente
          iure beatae corporis tempore accusamus, velit ratione eius dolore repellendus rerum atque,
          qui molestiae suscipit esse. Officiis amet molestiae qui, dolor incidunt blanditiis dolore
          consequuntur deserunt sunt doloremque saepe assumenda dolores dolorem similique dolorum
          placeat possimus beatae quibusdam.
        </p>
      </div>

      <div>
        <h2 class="ml-5 mt-10 text-3xl font-medium mb-3 mr-2 text-cyan-900">
          Вы отправили свое решение
        </h2>
      </div>
      <div class="flex justify-start">
        <h2 class="ml-5 mt-2 text-3xl font-bold mb-8 mr-2 text-cyan-900">Оценка:</h2>
        <h2 class="ml-5 mt-2 text-3xl font-bold mb-8 mr-2 text-cyan-900">45</h2>
        <h2 class="ml-1 mt-2 text-3xl font-bold mb-8 mr-1 text-cyan-900">/</h2>
        <h2 class="ml-1 mt-2 text-3xl font-bold mb-8 mr-1 text-cyan-900">100</h2>
      </div>
    </body>
  </div>
</template>
