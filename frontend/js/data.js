const KEY = "reliefLinkData";

const seed = {
  volunteers: [
    {
      id: 1,
      name: "Priya Nair",
      age: 24,
      gender: "Female",
      phone: "9876543210",
      email: "priya.nair@relieflink.org",
      address: "Aluva",
      skills: "First aid, community support",
      availability: "Full time",
      emergency: "9876543211"
    },
    {
      id: 2,
      name: "Rahul Menon",
      age: 29,
      gender: "Male",
      phone: "9876543212",
      email: "rahul.menon@relieflink.org",
      address: "Kalamassery",
      skills: "Logistics, transportation",
      availability: "Full time",
      emergency: "9876543213"
    },
    {
      id: 3,
      name: "Ananya Thomas",
      age: 27,
      gender: "Female",
      phone: "9876543214",
      email: "ananya.thomas@relieflink.org",
      address: "Edappally",
      skills: "Medical support",
      availability: "Weekends",
      emergency: "9876543215"
    }
  ],

  resources: [
    {
      id: 1,
      name: "Drinking Water",
      category: "Water",
      quantity: 240,
      unit: "bottles",
      location: "Aluva Relief Center",
      status: "Available"
    },
    {
      id: 2,
      name: "Rice Bags",
      category: "Food",
      quantity: 85,
      unit: "bags",
      location: "Kalamassery Storage Point",
      status: "Available"
    },
    {
      id: 3,
      name: "First Aid Kits",
      category: "Medical",
      quantity: 32,
      unit: "kits",
      location: "Edappally Relief Center",
      status: "Available"
    },
    {
      id: 4,
      name: "Emergency Blankets",
      category: "Shelter",
      quantity: 120,
      unit: "pieces",
      location: "Aluva Relief Center",
      status: "Available"
    }
  ],

  shelters: [
    {
      id: 1,
      name: "Aluva Community Hall",
      location: "Aluva",
      capacity: 150,
      occupancy: 112,
      contact: "Suresh Kumar",
      phone: "9876543220",
      status: "Open"
    },
    {
      id: 2,
      name: "Kalamassery Government School",
      location: "Kalamassery",
      capacity: 200,
      occupancy: 164,
      contact: "Meera Joseph",
      phone: "9876543221",
      status: "Open"
    },
    {
      id: 3,
      name: "Edappally Relief Center",
      location: "Edappally",
      capacity: 100,
      occupancy: 78,
      contact: "Arun Mathew",
      phone: "9876543222",
      status: "Open"
    }
  ],

  requests: [
    {
      id: "REQ-1042",
      requester: "Ramesh Kumar",
      phone: "9876543230",
      location: "Aluva",
      type: "Water and Food",
      description: "Family of five requires drinking water and food supplies.",
      priority: "High",
      people: 5,
      date: "2026-09-18T09:30",
      status: "Pending",
      history: [
        "Request created"
      ]
    },
    {
      id: "REQ-1041",
      requester: "Lakshmi Menon",
      phone: "9876543231",
      location: "Kalamassery",
      type: "Medical Assistance",
      description: "Elderly resident requires basic medical assistance.",
      priority: "High",
      people: 1,
      date: "2026-09-18T08:45",
      status: "Pending",
      history: [
        "Request created"
      ]
    },
    {
      id: "REQ-1040",
      requester: "Joseph Thomas",
      phone: "9876543232",
      location: "Edappally",
      type: "Shelter",
      description: "A group of residents requires temporary shelter.",
      priority: "Medium",
      people: 20,
      date: "2026-09-18T07:15",
      status: "Pending",
      history: [
        "Request created"
      ]
    }
  ]
};

let state = JSON.parse(localStorage.getItem(KEY) || "null") || seed;

const listeners = new Set();

function persist() {
  localStorage.setItem(KEY, JSON.stringify(state));
  listeners.forEach(fn => fn());
}

export const store = {
  get: (type) => state[type],

  subscribe: (fn) => {
    listeners.add(fn);
    return () => listeners.delete(fn);
  },

  add: (type, item) => {
    state[type].unshift({
      ...item,
      id: type === "requests"
        ? `REQ-${1043 + state.requests.length}`
        : Date.now()
    });

    persist();
  },

  update: (type, id, item) => {
    const i = state[type].findIndex(
      x => String(x.id) === String(id)
    );

    if (i > -1) {
      state[type][i] = {
        ...state[type][i],
        ...item
      };

      persist();
    }
  },

  remove: (type, id) => {
    state[type] = state[type].filter(
      x => String(x.id) !== String(id)
    );

    persist();
  },

  reset: () => {
    state = structuredClone(seed);
    persist();
  }
};