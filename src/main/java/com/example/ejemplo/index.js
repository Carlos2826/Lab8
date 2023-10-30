let baseUrl = `http://localhost:8080`;
let productos = [];

function cargarProductos() {
	console.log("La función cargarProductos se está ejecutando...");
	fetch(baseUrl + `/productos/all`)
		.then((response) => {
			response.json().then((json) => {
				productos = json;
				ImprimirProductos();
			});
		})
		.catch((error) => console.error("Error al cargar los datos:", error));
}

function ImprimirProductos() {
	let contenedor = document.getElementById("product-table-body");
	contenedor.innerHTML = "";

	productos.forEach((producto) => {
		contenedor.innerHTML += MapearProducto(producto);
	});
}

function MapearProducto(producto) {
	return `<tr class="even:bg-gray-100 odd:bg-gray-20">
	<td class="border border-slate-300">
	<button class = "w-28 p-2 m-2 text-sm bg-yellow-500 font-semibold text-white hover:bg-yellow-700" onclick="PopularDatosCampos(${producto.id})">Actualizar</button>
	<button class = "w-28 p-2 m-2 text-sm bg-red-500 font-semibold text-white hover:bg-red-700" onclick="EliminarProducto(${producto.id})">Eliminar</button>
	</td>
	<td class="p-2 text-ellipsis border border-slate-300">${producto.id}</td>
	<td class="p-2 text-ellipsis border border-slate-300">${producto.nombre}</td>
	<td class="p-2 text-ellipsis border border-slate-300">${producto.precio}</td>
	<td class="p-2 text-ellipsis border border-slate-300">${producto.categoriaId}</td>
	<td class="p-2 text-ellipsis border border-slate-300">${producto.foto}</td>
	<td class="p-2 text-ellipsis border border-slate-300">${producto.fecha_preparacion}</td>
	<td class="p-2 text-ellipsis border border-slate-300">${producto.fecha_expiracion}</td>
</tr>`;
}

function EliminarProducto(pid) {
	fetch(baseUrl + "/producto/" + pid, { method: "Delete" }).then((res) => {
		console.log(res);
		cargarProductos();
	});
}

function GuardarProducto() {
	let data = {
		nombre: document.getElementById("nombre").value,
		precio: document.getElementById("precio").value,
		categoriaId: document.getElementById("categoriaId").value,
		foto: document.getElementById("foto").value,
		fecha_preparacion: document.getElementById("fecha_preparacion").value,
		fecha_expiracion: document.getElementById("fecha_expiracion").value,
	};

	fetch(baseUrl + "/producto", {
		method: "POST",
		body: JSON.stringify(data),
		headers: {
			"Content-type": "application/json; charset=UTF-8",
		},
	}).then((res) => {
		cargarProductos();
	});
}

function PopularDatosCampos(pid) {
	let producto = productos.filter((p) => {
		return p.id == pid;
	})[0];

	document.getElementById("nombre").value = producto.nombre;
	document.getElementById("precio").value = producto.precio;
	document.getElementById("categoriaId").value = producto.categoriaId;
	document.getElementById("foto").value = producto.foto;
	document.getElementById("fecha_preparacion").value =
		producto.fecha_preparacion;
	document.getElementById("fecha_expiracion").value = producto.fecha_expiracion;
	document.getElementById("productoId").value = producto.id;
}

function ActualizarProducto() {
	let data = {
		nombre: document.getElementById("nombre").value,
		precio: document.getElementById("precio").value,
		categoriaId: document.getElementById("categoriaId").value,
		foto: document.getElementById("foto").value,
		fecha_preparacion: document.getElementById("fecha_preparacion").value,
		fecha_expiracion: document.getElementById("fecha_expiracion").value,
		id: document.getElementById("productoId").value,
	};

	fetch(baseUrl + "/producto", {
		method: "PUT",
		body: JSON.stringify(data),
		headers: {
			"Content-type": "application/json; charset=UTF-8",
		},
	}).then((res) => {
		cargarProductos();
	});
}
