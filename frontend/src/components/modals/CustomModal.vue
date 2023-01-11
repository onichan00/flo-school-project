<template>
<!-- classes="modal-container" content-class="modal-content" -->
<!-- classes="w-full h-full flex items-center justify-center" -->
<!--  params, -->
  <VueFinalModal v-bind="$attrs" classes="modal-container" content-class="modal-content">
    <div class="bg-white relative rounded-lg">
      <div class="flex items-center justify-between p-4 border-b rounded-t dark:border-gray-600">
        <h3 class="modal__title text-xl font-semibold text-gray-900">
          <slot name="title"></slot>
        </h3>
        <button @click="this.$emit('close')" type="button" class="modal__close text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center">
          <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
          <span class="sr-only">Close modal</span>
        </button>
      </div>
      <div class="p-4">
        <slot name="body"></slot>
<!--        <slot :params="params"></slot>-->
      </div>
      <div class="flex items-center p-4 space-x-2 border-t border-gray-200">
        <slot name="footer"></slot>
      </div>
    </div>
  </VueFinalModal>
</template>


<script>
// https://vue-final-modal.org/examples/recommend
import {VueFinalModal} from "vue-final-modal";

export default {
  name: 'CustomModal',
  inheritAttrs: false,
  emits: ['close'],
  components: { VueFinalModal }
}
</script>


<style scoped>
  ::v-deep(.modal-container) {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  ::v-deep(.modal-content) {
    position: relative;
    display: flex;
    flex-direction: column;
    max-height: 90%;
    margin: 0 1rem;
    width: 56rem;
  }
</style>

<style scoped>
  .dark-mode div ::v-deep(.modal-content) {
    border-color: #2d3748;
    background-color: #1a202c;
  }
</style>
