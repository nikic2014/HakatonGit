<template>
  <div class="flex justify-center items-center">
    <div class="fixed top-0 left-0 h-full w-full bg-black z-10 opacity-60"></div>
    <div
      class="bg-white w-80 h-3/5 z-20 p-8 v-auto-animate rounded-md items-center fixed top-20 overflow-hidden"
    >
      <div class="flex justify-between">
        <h2 class="text-xl font-bold mb-8 ml-14">Создать курс</h2>
        <h3 class="close">x</h3>
      </div>

      <div class="input-box">
        <input type="text" placeholder="Название" required />
        <i class="bx bxs-lock-alt"></i>
      </div>

      <label class="input-label">
        <textarea class="input input-textarea" cols="40" rows="3" placeholder="Описание"></textarea>
      </label>

      <div>
        <div class="input-box">
          <input type="text" placeholder="Учащийся" required />
        </div>

        <button
          id="addStudent"
          class="border-2 border-lime-300 rounded-lg w-8 h-8 mr-2 hover:bg-gray-200"
        >
          +
        </button>
        <button class="border-2 border-lime-300 rounded-lg w-8 h-8 hover:bg-gray-200">-</button>
      </div>

      <div>
        <button
          class="pb-1 px-4 items-center transition bg-teal-700 w-32 h-8 rounded-lg text-white disabled:bg-slate-300 hover:bg-teal-600 active:bg-teal-500 cursor-pointer ml-16 mt-16"
        >
          Создать
        </button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.input-box input,
.input-label textarea {
  width: 100%;
  height: 30px;
  background: transparent;
  border: none;
  outline: none;
  border: 2px solid rgba(0, 0, 0, 0.2);
  border-radius: 12px;
  font-size: 16px;
  color: black;
  padding: 20px 10px 20px 10px;
  margin-bottom: 15px;
}

.input-label textarea {
  height: 80px;
  padding: 10px 10px 10px 10px;
}

.input-box input::placeholder,
.input-label textarea::placeholder {
  color: rgb(208, 208, 208);
}

.input-box i {
  position: absolute;
  right: 10px;
  top: 30%;
  transform: translateX(-50%);
  font-size: 20px;
}

.close {
  position: absolute;
  top: 0;
  right: 0;
  width: 30px;
  height: 30px;
  background: #162938;
  font-size: 1em;
  color: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
  border-bottom-left-radius: 10px;
  cursor: pointer;
}
</style>
