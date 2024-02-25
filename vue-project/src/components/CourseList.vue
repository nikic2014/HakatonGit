<script setup>
import { ref } from 'vue'
import Course from './Course.vue'

const courses = ref([
  'Курс 1',
  'Курс 2',
  'Курс 3',
  'Курс 4',
  'Курс 5',
  'Курс 6',
  'Курс 7',
  'Курс 8',
  'Курс 9',
  'Курс 10'
])

const description = ref(
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt atque placeat harum, qui sapiente delectus voluptate quibusdam iure totam quaerat ad a, sed pariatur ut cum dignissimos accusantium? Voluptatum, sequi.',
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt atque placeat harum, qui sapiente delectus voluptate quibusdam iure totam quaerat ad a, sed pariatur ut cum dignissimos accusantium? Voluptatum, sequi.',
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt atque placeat harum, qui sapiente delectus voluptate quibusdam iure totam quaerat ad a, sed pariatur ut cum dignissimos accusantium? Voluptatum, sequi.',
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt atque placeat harum, qui sapiente delectus voluptate quibusdam iure totam quaerat ad a, sed pariatur ut cum dignissimos accusantium? Voluptatum, sequi.',
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt atque placeat harum, qui sapiente delectus voluptate quibusdam iure totam quaerat ad a, sed pariatur ut cum dignissimos accusantium? Voluptatum, sequi.',
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt atque placeat harum, qui sapiente delectus voluptate quibusdam iure totam quaerat ad a, sed pariatur ut cum dignissimos accusantium? Voluptatum, sequi.',
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt atque placeat harum, qui sapiente delectus voluptate quibusdam iure totam quaerat ad a, sed pariatur ut cum dignissimos accusantium? Voluptatum, sequi.',
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt atque placeat harum, qui sapiente delectus voluptate quibusdam iure totam quaerat ad a, sed pariatur ut cum dignissimos accusantium? Voluptatum, sequi.',
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt atque placeat harum, qui sapiente delectus voluptate quibusdam iure totam quaerat ad a, sed pariatur ut cum dignissimos accusantium? Voluptatum, sequi.',
  'Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt atque placeat harum, qui sapiente delectus voluptate quibusdam iure totam quaerat ad a, sed pariatur ut cum dignissimos accusantium? Voluptatum, sequi.'
)

// const courses = ref([
//   'Курс Aaa',
//   'Курс Bbb',
//   'Курс Ccc',
//   'Курс Ddd',
//   'Курс Eee',
//   'Курс Fff',
//   'Курс Ggg',
//   'Курс Hhh',
//   'Курс Iii',
//   'Курс Jjj'
// ])

const sortBy = ref('А - Я')

function sortCourses() {
  const sorted = [...courses.value]

  sorted.sort((a, b) => {
    if (sortBy.value === 'А - Я') {
      return a.localeCompare(b, 'ru', { numeric: true })
    } else if (sortBy.value === 'Я - А') {
      return b.localeCompare(a, 'ru', { numeric: true })
    }
  })

  courses.value = sorted
}
</script>

<template v-auto-animate>
  <div>
    <select
      v-model="sortBy"
      @change="sortCourses"
      class="pl-2 mt-1 mb-10 rounded-xl w-36 h-8 outline-cyan-600"
    >
      <option value="А - Я">А - Я</option>
      <option value="Я - А">Я - А</option>
    </select>

    <div class="grid grid-cols-3 gap-10">
      <Course
        v-for="(course, index) in courses"
        :key="index"
        :title="course"
        :description="description"
      />
    </div>
  </div>
</template>
