<template>
  <div class="container">
    <div class="row">
      <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
        <h1>Filters & Mixins</h1>
        <p>{{ text }}</p>
        <p>{{ text | to-uppercase }}</p>
        <p>{{ text | to-lowercase }}</p>
        <p>{{ text | toCapitalize }}</p>

        <input type="text" v-model="filterText">
        <ul>
          <li v-for="(fruit, index) in filteredFruits" :key="index">{{ fruit }}</li>
        </ul>

        <hr>

        <list/>
      </div>
    </div>
  </div>
</template>

<script>

import List from "./List";
import { fruitMixin } from './fruitMixin.js';

export default {
  data() {
    return {
      text: "Hello thERe",

    };
  },
  filters: {
    "to-uppercase": function(value) {
      return value.toUpperCase();
    },
    toCapitalize: value =>
      value
        .split(" ")
        .map(letter => letter[0].toUpperCase() + letter.slice(1).toLowerCase())
        .join(" ")
  },
  mixins: [fruitMixin],
  components: {
    List
  }
};
</script>

<style>
</style>
