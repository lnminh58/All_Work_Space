<template>
  <div class="container">
    <div class="row">
      <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
        <h1>Built-in Directives</h1>
        <p v-text="'Some Text'"></p>
        <p v-html="'<strong>Some strong text</strong>'"></p>
      </div>
    </div>
    <div class="row">
      <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
        <h1>Custom Directives</h1>
        <p v-hightlight:backgroundcolor.delayed="'red'">Color this</p>
        <p v-local-hightlight:backgroundcolor.delayed="'red'">Color this</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  directives: {
    localHightlight: {
      bind(el, binding, vnode) {
        //  el.style.backgroundColor = 'green'
        //  el.style.backgroundColor = binding.value
        let delay = 0;
        if (binding.modifiers["delayed"]) {
          delay = 1000;
        }

        setTimeout(() => {
          if (binding.arg === "background") {
            el.style.backgroundColor = binding.value;
          } else {
            el.style.color = binding.value;
          }
        }, delay);
      }
    }
  }
};
</script>

<style>
</style>
