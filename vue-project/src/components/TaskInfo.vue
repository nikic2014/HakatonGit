<script setup>
import { useRouter, useRoute } from 'vue-router'
import { ref } from 'vue'
import Header from './Header.vue'
import { showbutton } from './Main.vue'
import CheckTask from './CheckTask.vue'

const router = useRouter()
const route = useRoute()

const title = route.query.title
const titleTask = route.query.titleTask

let saved = false
let textAreaContent =
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores dolor, voluptates error ab voluptas repellendus totam ratione vitae delectus labore?'

function back(title) {
  router.push({ path: '/courseinfo', query: { title: title } })
}

const randomScore = Math.floor(Math.random() * 101)

function saveChanges() {
  saved = true
}

var showAddCourse4 = ref(false)

function toggleAddCourse4() {
  showAddCourse4.value = !showAddCourse4.value
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
        <textarea
          :readonly="!showbutton"
          v-model="textAreaContent"
          class="outline-none ml-14 w-11/12 rounded-lg bg-gray-100"
          name=""
          id=""
          cols="30"
          rows="10"
        >
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Quia, culpa sapiente ut porro vel laboriosam facere harum laborum cum dignissimos voluptatum consequuntur maxime magni doloremque vero cupiditate omnis soluta aspernatur repellat quam temporibus vitae ea provident atque. Odio ipsa deleniti ab corporis tempora veniam numquam, omnis itaque eveniet minus blanditiis natus. Delectus tempora libero deleniti officia, at minima quo distinctio eius saepe nihil veniam hic tenetur fugiat sunt reiciendis debitis nobis magni aut, laudantium repellat praesentium, ab doloribus consequatur. Sed doloremque, qui asperiores at nam vel odit corporis recusandae. Vero at reiciendis sapiente vitae. Cupiditate recusandae possimus quaerat sint. Rerum consequuntur explicabo enim ab beatae repellendus error ducimus voluptas, qui molestiae dolorum distinctio excepturi odit voluptates placeat ratione, repudiandae cupiditate obcaecati aliquam atque eaque aperiam veniam saepe! Deserunt doloremque officiis perferendis eum voluptates! A repudiandae perspiciatis, nobis veniam eligendi velit sed asperiores qui molestias magnam, nemo ipsum soluta minima nesciunt obcaecati repellendus, pariatur beatae odit officia voluptates ratione rem autem rerum neque? Eveniet quisquam similique nihil cupiditate distinctio voluptatem sequi minima corrupti veniam iste. Quis temporibus sapiente quibusdam quae assumenda! Amet ducimus hic, temporibus veniam culpa sapiente id dolore rerum vero, ipsum porro, ea expedita cum odit illum? Facere, repudiandae?
        </textarea>
      </div>

      <div v-if="!showbutton">
        <h2 class="ml-5 mt-10 text-3xl font-medium mb-3 mr-2 text-cyan-900">
          Вы отправили свое решение
        </h2>
      </div>
      <div v-if="!showbutton" class="flex justify-start">
        <h2 class="ml-5 mt-2 text-3xl font-bold mb-8 mr-2 text-cyan-900">Оценка:</h2>
        <h2 class="ml-5 mt-2 text-3xl font-bold mb-8 mr-2 text-cyan-900">{{ randomScore }}</h2>
        <h2 class="ml-1 mt-2 text-3xl font-bold mb-8 mr-1 text-cyan-900">/</h2>
        <h2 class="ml-1 mt-2 text-3xl font-bold mb-8 mr-1 text-cyan-900">100</h2>
      </div>

      <div v-if="showbutton" class="flex justify-start">
        <button
          @click="toggleAddCourse4"
          class="mt-10 ml-8 pb-1 px-4 items-center transition bg-cyan-700 w-38 h-8 rounded-xl text-white disabled:bg-slate-300 hover:bg-amber-600 active:bg-cyan-800 cursor-pointer"
        >
          Проверить задание
        </button>
        <button
          @click="saveChanges"
          class="mt-10 ml-8 pb-1 px-4 items-center transition bg-cyan-700 w-38 h-8 rounded-xl text-white disabled:bg-slate-300 hover:bg-amber-600 active:bg-cyan-800 cursor-pointer"
        >
          Сохранить изменения
        </button>
      </div>
    </body>
    <CheckTask id="add" v-if="showAddCourse4" @close="toggleAddCourse4" />
  </div>
</template>
