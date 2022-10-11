<!--<template>-->
<!--  <template>-->
<!--    &lt;!&ndash;    <router-link :to="to" class="link" :class="{ active: isActive }">&ndash;&gt;-->
<!--    &lt;!&ndash;      <i class="icon" :class="icon" />&ndash;&gt;-->
<!--    &lt;!&ndash;      <transition name="fade">&ndash;&gt;-->
<!--    &lt;!&ndash;      <span v-if="!collapsed">&ndash;&gt;-->
<!--    &lt;!&ndash;        <slot />&ndash;&gt;-->
<!--    &lt;!&ndash;      </span>&ndash;&gt;-->
<!--    &lt;!&ndash;      </transition>&ndash;&gt;-->
<!--    &lt;!&ndash;    </router-link>&ndash;&gt;-->
<!--    <span v-if="!collapsed">-->
<!--      <router-link :to="to" class="link" :class="{ active: isActive }">-->
<!--      <i class="icon" :class="icon"/>-->
<!--        <slot/>-->
<!--      <transition name="fade"></transition>-->
<!--    </router-link>-->
<!--    </span>-->
<!--    <span v-else>-->
<!--      <i class="icon" :class="icon"/>-->
<!--    </span>-->
<!--  </template>-->
<!--</template>-->

<!--<script>-->
<!--import {computed} from 'vue'-->
<!--import {useRoute} from 'vue-router'-->
<!--import {collapsed} from './state.js'-->

<!--export default {-->
<!--  props: {-->
<!--    to: {type: String, required: true},-->
<!--    icon: {type: String, required: true}-->
<!--  },-->
<!--  setup(props) {-->
<!--    const route = useRoute()-->
<!--    const isActive = computed(() => route.path === props.to)-->
<!--    return {isActive, collapsed}-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--.fade-enter-active,-->
<!--.fade-leave-active {-->
<!--  transition: opacity 0s;-->
<!--}-->

<!--.fade-enter,-->
<!--.fade-leave-to {-->
<!--  opacity: 0;-->
<!--}-->

<!--.link {-->
<!--  display: flex;-->
<!--  align-items: center;-->
<!--  cursor: pointer;-->
<!--  position: relative;-->
<!--  font-weight: 400;-->
<!--  user-select: none;-->
<!--  border-radius: 0.25em;-->
<!--  height: 1.5em;-->
<!--  color: #282828;-->
<!--  text-decoration: none;-->
<!--}-->

<!--.link .icon {-->
<!--  flex-shrink: 0;-->
<!--  width: 25px;-->
<!--  margin-right: 10px;-->
<!--}-->

<!--</style>-->

<script>
import { computed } from 'vue'
import { useRoute } from 'vue-router'
import { collapsed } from './state'
export default {
  props: {
    to: { type: String, required: true },
    icon: { type: String, required: true }
  },
  setup(props) {
    const route = useRoute()
    const isActive = computed(() => route.path === props.to)
    return { isActive, collapsed }
  }
}
</script>

<template>
  <router-link :to="to" class="link" :class="{ active: isActive }">
    <i class="icon" :class="icon" />
    <transition name="fade">
      <span v-if="!collapsed">
        <slot />
      </span>
    </transition>
  </router-link>
</template>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.1s;
}
.fade-enter,
.fade-leave-to {
  opacity: 0;
}
.link {
  transition: 0.3s;
  display: flex;
  align-items: center;
  cursor: pointer;
  position: relative;
  user-select: none;
  color: #000000;
  text-decoration: none;
}

.link.active {
  background-color: #F15922;
  color: #ffffff;
}

.link .icon {
  flex-shrink: 0;
  width: 25px;
  margin: 10px;
}
</style>