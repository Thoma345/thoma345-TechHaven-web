<script>
  const navLinks = document.querySelectorAll('.nav a');

  navLinks.forEach(link => {
    link.addEventListener('click', function(e) {
      if (this.nextElementSibling.classList.contains('active')) {
        this.nextElementSibling.classList.remove('active');
      } else {
        let activeMenu = document.querySelector('.nav a + .active');
        if (activeMenu) activeMenu.classList.remove('active');
        this.nextElementSibling.classList.add('active');
      }
      e.preventDefault(); 
    });
  });
</script>


<script>
  const links = document.querySelectorAll('a[href^="#"]');

  links.forEach(link => {
    link.addEventListener('click', function(e) {
      const target = document.querySelector(this.hash);
      if (target) {
        e.preventDefault();
        const scrollY = target.getBoundingClientRect().top + window.pageYOffset;
        const headerHeight = document.querySelector('header').offsetHeight;
        window.scrollTo({ top: scrollY - headerHeight, behavior: 'smooth' });
      }
    });
  });
</script>

<script>
  const gallery = document.querySelector('.gallery');
  const images = gallery.querySelectorAll('img');
  let currentImage = 0;

  function moveToImage(newIndex) {
    images[currentImage].classList.remove('active');
    currentImage = newIndex;
    images[currentImage].classList.add('active');
    gallery.scroll({ left: currentImage * images[0].clientWidth, behavior: 'smooth' });
  }

  const nextButton = document.querySelector('.next');
  nextButton.addEventListener('click', () => {
    moveToImage(currentImage === images.length - 1 ? 0 : currentImage + 1);
  });

  const prevButton = document.querySelector('.prev');
  prevButton.addEventListener('click', () => {
    moveToImage(currentImage === 0 ? images.length - 1 : currentImage - 1);
  });
</script>