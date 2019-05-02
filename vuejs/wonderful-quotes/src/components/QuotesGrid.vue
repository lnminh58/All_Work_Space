<template>
  <div class="row">
    <quote
      v-for="(quote, index) in quotes"
      @click.native="deleteQuote(index)"  
      :key="index"
    >
      {{ quote }}
    </quote>
  </div>
</template>
<script>
import Quote from './Quote.vue';
export default {
  props: ['quotes'],
  components: {
    Quote,
  },
  methods: {
    deleteQuote(index) {
      this.$emit('onQuoteDelete', index)
    }
  },
}
</script>

<style scoped>

</style>
