<template>
  <div class="flex flex-col p-4 bg-white drop-shadow-sm">
    <div class="flex flex-col md:flex-row mb:items-center justify-between">
      <div class="flex flex-row text-2xl items-center mb-2 md:mb-0 relative justify-center">
        <button class="mr-2 absolute md:relative left-0">
          <Icon icon="ic:baseline-menu" class="text-4xl text-florijnOrange" />
        </button>
        <!-- TODO Center the title -->
        <p class="font-medium">{{ currentRouteName }}</p>
      </div>
      <div class="flex flex-row">
        <input placeholder="search" class="flex-grow rounded-md pl-2 pr-2 py-1 text-2xl bg-gray-100 border-2 focus:outline-none focus:ring focus:ring-florijnOrange/50 focus:border-florijnOrange" />
        <button v-on:click="openFilter()" class="ml-2">
          <Icon icon="mdi:filter-variant" class="text-4xl text-florijnOrange" />
        </button>
      </div>
    </div>
    <div class="flex" id="filterMenu">
      <p class="content collapsed transition-all duration-500">Lorem ipsum dolor sit amet, consectetur adipiscing elit.
        Suspendisse sit amet lacinia quam. Suspendisse vehicula volutpat molestie. Aenean erat lectus, eleifend eget
        magna at, gravida semper lectus. Phasellus vitae leo lobortis dolor dapibus posuere. Fusce nec volutpat elit, eu
        laoreet sapien. Nam est nulla, iaculis quis tortor non, luctus consectetur urna. Vestibulum ante ipsum primis in
        faucibus orci luctus et ultrices posuere cubilia curae; Aliquam eu nunc tellus. In vitae libero nec ex euismod
        pharetra vitae id purus. Cras convallis ex eu convallis cursus. Donec nulla nisi, luctus sed condimentum ut,
        congue sit amet felis. Mauris bibendum orci ut est convallis scelerisque. Nulla posuere nunc id aliquam
        consequat.</p>
    </div>
  </div>
</template>

<script>
// import { Icon } from '@iconify/vue';

export default {
  name: 'PageHeader',
  props: ['title'],
  components: {
    // Icon,
  },
  methods: {
    openFilter() {
      const toggle = document.querySelector("#filterMenu");
      const content = toggle.firstChild;

      content.classList.toggle("collapsed");
      content.classList.toggle("mt-4");
    }
  },

  computed: {
    currentRouteName() {
      return this.$route.name;
    }
  }
}
</script>

<style scoped>
.content {
  max-height: 600px;
  height: auto;
  overflow: hidden;
  /* transition: max-height 0.5s ease-in-out; */
}

.collapsed {
  max-height: 0px;
}
</style>