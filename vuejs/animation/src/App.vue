<template>
  <div class="container">
    <div class="row">
      <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
        <h1>Animations</h1>
        <hr>
        <select v-model="alertAnimation" class="form form-control">
          <option value="fade">fade</option>
          <option value="slide">slide</option>
        </select>
        <br>
        <br>
        <button class="btn btn-primary" @click="show = !show">Show Alert</button>
        <br>
        <br>
        <!-- <transition :name="alertAnimation">
          <div class="alert alert-info" v-if="show">This is some Info</div>
        </transition>

        <transition name="slide" type="transition">
          <div class="alert alert-info" v-if="show">This is some Info</div>
        </transition>

        <transition 
            appear
            enter-active-class="animated bounce"
            leave-active-class="animated shake"
        >
          <div class="alert alert-info" v-if="show">This is some Info</div>
        </transition>-->

        <transition :name="alertAnimation" mode="out-in">
          <div class="alert alert-info" v-if="show" key="info">This is some Info</div>
          <div class="alert alert-warning" v-else key="warning">This is some Warning</div>
        </transition>
        <hr>

        <button class="btn btn-primary" @click="load = !load">load / Remove Element</button>
        <br>
        <br>
        <transition
          @before-enter="beforeEnter"
          @enter="enter"
          @after-enter="afterEnter"
          @enter-cancelled="enterCanceled"
          @before-leave="beforeLeave"
          @leave="leave"
          @after-leave="afterLeave"
          @leave-cancelled="afterCancelled"
        >
          <div style="width: 100px; height: 100px; background-color: lightgreen" v-if="load"></div>
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      show: false,
      load: true,
      alertAnimation: "fade"
    };
  },
  methods: {
      beforeEnter(el) {
          console.log('beforeEnter:::', el)
      },
      enter(el, done) {
          console.log('enter:::', el, done)
          done()
      },
      afterEnter(el) {
          console.log('afterEnter:::', el)
      },
      enterCanceled(el) {
          console.log('enterCanceled:::', el)
      },
      beforeLeave(el) {
          console.log('beforeLeave:::', el)
      },
      leave(el, done) {
          console.log('leave:::', el, done)
          done()
      },
      afterLeave(el) {
          console.log('afterLeave:::', el)
      },
      afterCancelled(el) {
          console.log('afterCancelled:::', el)
      },
  }
};
</script>

<style>
.fade-enter {
  opacity: 0;
}
.fade-enter-active {
  transition: opacity 1s;
  /* opacity: 1; */
}
.fade-leave {
  /* opacity: 1; */
}
.fade-leave-active {
  transition: opacity 1s;
  opacity: 0;
}

.slide-enter {
}
.slide-enter-active {
  animation: slide-in 1s ease-out forwards;
  transition: opacity 0.5s;
}
.slide-leave {
}
.slide-leave-active {
  animation: slide-out 1s ease-out forwards;
  transition: opacity 3s;
  opacity: 0;
}

@keyframes slide-in {
  from {
    transform: translateY(20px);
  }
  to {
    transform: translateY(0px);
  }
}

@keyframes slide-out {
  from {
    transform: translateY(0px);
  }
  to {
    transform: translateY(20px);
  }
}
</style>
