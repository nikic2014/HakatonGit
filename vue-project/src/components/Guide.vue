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
      <h3 class="text-2xl font-bold text-center mb-4 text-cayn-800">
        Гайд по загрузке решений на платформу
      </h3>

      <form action="">
        <!-- описание -->
        <div class="mb-2 pl-3 pr-3 pt-2 pb-2 border-2 border-cyan-600 rounded-lg w-full">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Sint commodi architecto itaque
          eos vitae in odit cupiditate consequuntur voluptas! Dolorum dicta eum inventore hic autem
          praesentium error reprehenderit dignissimos, culpa ab itaque, enim voluptate placeat a
          ipsum similique omnis cupiditate fuga incidunt eveniet laudantium architecto suscipit? At
          dolor tempora rerum illo quasi obcaecati distinctio? Soluta aut unde iste esse, maiores
          enim saepe ea illo, deleniti voluptates minus veritatis molestias commodi nobis sunt
          officiis consectetur. Architecto exercitationem, quasi voluptate officiis consequuntur a
          aliquid, facere atque doloremque porro odio enim doloribus eum iste expedita voluptatibus
          quaerat. Quos, impedit ducimus accusamus earum odio vel tempore in soluta blanditiis omnis
          libero, iste quas modi fuga nulla eveniet? Delectus quod, inventore necessitatibus, minus
          saepe sequi aperiam itaque tempora quos nobis corrupti molestiae eligendi sunt dolor neque
          quasi unde, vitae sed cum ducimus animi dolorum iusto. Perspiciatis ab optio tenetur
          facilis placeat alias, error nemo pariatur, modi expedita id repellat consectetur odio?
          Voluptates explicabo quam adipisci molestias nostrum distinctio neque sunt. Quis veniam
          beatae eos sed. Rerum, veniam? Ratione odio perspiciatis soluta corrupti totam voluptates,
          nulla est cum voluptatibus repellendus earum quia excepturi aspernatur ea minus fugit
          repellat possimus veritatis ducimus sit labore veniam recusandae esse!
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped></style>
