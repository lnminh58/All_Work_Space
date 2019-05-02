<template>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <button @click="selectedComponent = 'appQuote'">Quote</button>
        <button @click="selectedComponent = 'appAuthor'">Author</button>
        <button @click="selectedComponent = 'appNew'">New</button>
        <hr>
        <keep-alive>
          <component :is="selectedComponent">
            <p class="text-dark">Default Content {{ selectedComponent }}</p>
          </component>
        </keep-alive>

        <!-- <app-quote>
          <h1 slot="title">{{ quoteTitle }}</h1>
          <p slot="content">A Wonderful Quote</p>
        </app-quote>-->
      </div>
    </div>
  </div>
</template>

<script>
import Quote from "./components/Quote.vue";
import Author from "./components/Author.vue";
import New from "./components/New.vue";
export default {
  data: function() {
    return {
      quoteTitle: "The Quote",
      selectedComponent: "appQuote"
    };
  },
  components: {
    appQuote: Quote,
    appAuthor: Author,
    appNew: New
  }
};
</script>

<style scoped>
/* h1 {
        color: red
    } */
    p {
        font-weight: bold
    }
</style>
