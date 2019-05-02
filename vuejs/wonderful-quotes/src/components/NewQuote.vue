<template>
  <div>
    <div class="row my-2">
      <div class="col-sm-8 col-sm-offset-2 col-xs-12 col-md-6 col-md-offset-3 mx-auto">
        <label class="lead">Quote</label>
        <textarea class="form-control" cols="30" rows="5" v-model="quote"></textarea>
      </div>
    </div>
    <div class="row my-2">
      <div class="col-sm-8 col-sm-offset-2 col-xs-12 col-md-6 col-md-offset-3 mx-auto">
        <button class="btn btn-primary" @click.prevent="createNewQuote">Add Quotes</button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      quote: ""
    };
  },
  methods: {
    createNewQuote() {
      this.$emit("onNewQuoteSubmit", this.quote);
      this.quote = "";
    }
  }
};
</script>

<style scoped>
</style>
