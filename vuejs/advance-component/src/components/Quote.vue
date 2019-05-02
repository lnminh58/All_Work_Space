<template>
  <div class="m-4 mx-auto p-4 text-center shadow">
    <div class="title">
      <slot name='title'></slot>
    </div>
    <hr>
    <div>
      <slot></slot>
    </div>
  </div>
</template>
<script>
export default {
}
</script>

<style scoped>
    h1 {
        color: red 
    };
    .title {
      font-style: italic
    }
</style>
