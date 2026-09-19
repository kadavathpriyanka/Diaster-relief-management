import { getHealth } from './api.js';
import { dashboard } from './dashboard.js';
import { volunteers, bindVolunteers } from './volunteers.js';
import { resources, bindResources } from './resources.js';
import { shelters, bindShelters } from './shelters.js';
import { requests, bindRequests } from './requests.js';
import { tracking, bindTracking } from './tracking.js';
import { admin, bindAdmin } from './admin.js';
import { initializeModal } from './ui.js';

const app = document.querySelector('#app');
let online = false;
const pages = { dashboard:[dashboard,null,'Operations Dashboard','Operations / Overview'], volunteers:[volunteers,bindVolunteers,'Volunteer Management','Operations / Volunteers'], resources:[resources,bindResources,'Resource Inventory','Operations / Resources'], shelters:[shelters,bindShelters,'Shelter Management','Operations / Shelters'], requests:[requests,bindRequests,'Emergency Requests','Operations / Emergency Requests'], tracking:[tracking,bindTracking,'Live Request Tracking','Operations / Live Tracking'], admin:[()=>admin(online),bindAdmin,'Admin Dashboard','Administration / Overview'] };

async function health() {
  try {
    await getHealth();
    online = true;
  } catch (error) {
    online = false;
    console.error('Backend health request failed: http://localhost:8080/api/health', error);
  }

  const chip = document.querySelector('#health-chip');
  const sidebarStatus = document.querySelector('#sidebar-health');
  chip.className = `health-chip ${online ? '' : 'offline'}`;
  chip.innerHTML = `<i></i>Backend ${online ? 'Online' : 'Offline'}`;
  sidebarStatus.textContent = `Backend ${online ? 'online' : 'offline'}`;
}

function render() {
  let key = location.hash.slice(1) || 'dashboard';
  if (!pages[key]) key = 'dashboard';
  const [view, bind, title, crumb] = pages[key];
  document.title = `${title} | ReliefLink`;
  document.querySelector('#page-title').textContent = title;
  document.querySelector('#breadcrumb').textContent = crumb;
  document.querySelectorAll('[data-page]').forEach(link => link.classList.toggle('active', link.dataset.page === key));
  app.innerHTML = view();
  bind?.();
  document.querySelector('#sidebar').classList.remove('open');
  app.focus();
}

initializeModal();
document.querySelector('#menu-toggle').onclick = () => document.querySelector('#sidebar').classList.toggle('open');
document.querySelector('#refresh-button').onclick = async () => { await health(); render(); };
window.addEventListener('hashchange', render);
await health();
render();
setInterval(health, 60000);
