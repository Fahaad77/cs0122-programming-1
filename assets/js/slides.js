const slides = Array.from(document.querySelectorAll('.slide'));
const current = document.querySelector('[data-current-slide]');
const total = document.querySelector('[data-total-slides]');
const notesPanel = document.querySelector('[data-notes-panel]');
const notesContent = document.querySelector('[data-notes-content]');
const shell = document.querySelector('.deck-shell');
let index = Number(new URLSearchParams(location.search).get('slide') || 1) - 1;
let fragmentIndex = 0;

function classifySlides() {
  slides.forEach((slide, i) => {
    const text = slide.textContent.toLowerCase();
    const kicker = slide.querySelector('.kicker')?.textContent.toLowerCase() || '';
    if (i === 0 || kicker.includes('week')) slide.classList.add('slide-cover');
    if (kicker.includes('section')) slide.classList.add('slide-section');
    if (kicker.includes('predict') || text.includes('what is the exact output')) slide.classList.add('slide-question');
    if (kicker.includes('debug') || text.includes('find the')) slide.classList.add('slide-debug');
    if (kicker.includes('live code') || slide.querySelector('pre')) slide.classList.add('slide-code');
    if (kicker.includes('live code')) slide.classList.add('slide-live');
    if (text.includes('trace')) slide.classList.add('slide-trace');
    if (text.includes('output') || text.includes('println') || text.includes('printf')) slide.classList.add('slide-output');
    slide.querySelectorAll('pre').forEach((pre) => {
      if (pre.dataset.label) return;
      if (slide.classList.contains('slide-debug')) pre.dataset.label = 'Debug code';
      else if (slide.classList.contains('slide-trace') || kicker.includes('predict')) pre.dataset.label = 'Trace code';
      else if (text.includes('$ javac') || text.includes('$ java')) pre.dataset.label = 'Terminal demo';
      else pre.dataset.label = 'Java source';
    });
  });
}

function fragmentsFor(slide) {
  return Array.from(slide.querySelectorAll('[data-fragment], .fragment'));
}

function updateFragments(slide) {
  fragmentsFor(slide).forEach((fragment, i) => {
    fragment.classList.toggle('visible', i < fragmentIndex);
  });
}

function show(nextIndex, resetFragments = true) {
  index = Math.max(0, Math.min(slides.length - 1, nextIndex));
  if (resetFragments) fragmentIndex = 0;
  slides.forEach((slide, i) => slide.classList.toggle('active', i === index));
  const slide = slides[index];
  updateFragments(slide);
  current.textContent = String(index + 1);
  total.textContent = String(slides.length);
  const progress = slides.length > 1 ? (index / (slides.length - 1)) * 100 : 100;
  shell?.style.setProperty('--deck-progress', `${progress}%`);
  const note = slide.querySelector('.speaker-notes');
  notesContent.innerHTML = note ? note.innerHTML : '<p>No notes for this slide.</p>';
  history.replaceState(null, '', `?slide=${index + 1}`);
}

function next() {
  const fragments = fragmentsFor(slides[index]);
  if (fragmentIndex < fragments.length) {
    fragmentIndex += 1;
    updateFragments(slides[index]);
    return;
  }
  show(index + 1);
}

function previous() {
  if (fragmentIndex > 0) {
    fragmentIndex -= 1;
    updateFragments(slides[index]);
    return;
  }
  show(index - 1);
}

function toggleNotes() {
  notesPanel.hidden = !notesPanel.hidden;
}

classifySlides();
document.querySelector('[data-next]').addEventListener('click', next);
document.querySelector('[data-prev]').addEventListener('click', previous);
document.querySelector('[data-notes]').addEventListener('click', toggleNotes);

document.addEventListener('keydown', (event) => {
  if (event.key === 'ArrowRight' || event.key === 'PageDown' || event.key === ' ') next();
  if (event.key === 'ArrowLeft' || event.key === 'PageUp') previous();
  if (event.key.toLowerCase() === 's') toggleNotes();
  if (event.key === 'Home') show(0);
  if (event.key === 'End') show(slides.length - 1);
});

show(index);
