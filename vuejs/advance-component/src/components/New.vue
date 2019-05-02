<template>
  <div class="m-4 mx-auto p-4 text-center shadow">
    <h3>New Quote</h3>
    <button @click="counter++">increase</button>
    <p>{{ counter }}</p>
  </div>
</template>
<script>
export default {
  data: function () {
    return {
      counter: 0
    }
  },
  destroyed() {
    console.log('destroyed!')
  },
  deactivated() {
    console.log('Deactivated!')
    console.log(this.$slots)
  },
  activated() {
    console.log('activated!')
  }
}
</script>

<style scoped>

</style>
