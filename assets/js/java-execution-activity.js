const correctOrder = ['source','compiler','bytecode','jvm','output'];
const list = document.querySelector('[data-sort-list]');
const result = document.querySelector('[data-result]');
let dragged = null;
function currentOrder() { return [...list.querySelectorAll('li')].map((item) => item.dataset.step); }
function announce(message) { result.textContent = message; }
list.addEventListener('dragstart', (event) => { dragged = event.target.closest('li'); });
list.addEventListener('dragover', (event) => { event.preventDefault(); const target = event.target.closest('li'); if (!target || target === dragged) return; const rect = target.getBoundingClientRect(); const after = event.clientY > rect.top + rect.height / 2; list.insertBefore(dragged, after ? target.nextSibling : target); });
document.querySelector('[data-check]').addEventListener('click', () => { const ok = currentOrder().join(',') === correctOrder.join(','); announce(ok ? 'Correct. Java starts with source code and reaches output through compilation, bytecode, and the JVM.' : 'Not yet. Try source code, compiler, bytecode, JVM, then output.'); });
document.querySelector('[data-reset]').addEventListener('click', () => { [...list.children].sort((a,b) => Number(a.dataset.original) - Number(b.dataset.original)).forEach((item) => list.appendChild(item)); announce('Order reset.'); });
