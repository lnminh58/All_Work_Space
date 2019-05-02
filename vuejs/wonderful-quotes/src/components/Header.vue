<template>
  <div>
    <h3
      class="h5 text-muted"
    >Quotes Added</h3>
    <div class="progress">
      <div
        class="progress-bar progress-bar-striped  progress-bar-animated bg-success"
        role="progressbar"
        :style="{width: (quoteCount / maxQuotes)  * 100 + '%'}"
      >
        {{ quoteCount }} / {{maxQuotes}}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["quoteCount", "maxQuotes"]
};
</script>
<style scoped>
</style>
