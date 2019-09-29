<template>
	<div id="app" class="container" v-if="vehicleId">

		<div class="pt-5 border-bottom">
			<h2><span><img src="/images/mercedes-10.png" /></span> Vehicle <b>{{vehicleId}}</b></h2>
		</div>

		<div class="row pt-4"  v-if="doors">
			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-sm-2">
								<i class="fas" 
									v-bind:class="isDoorLocked(doors.doorlockstatusfrontleft) ? 'fa-lock' : 'fa-lock-open'"
									:title="doors.doorlockstatusrearright.value">
								</i>
							</div>

							<div class="col-sm-7 text-center">
								Front Left
							</div>

							<div class="col-sm-2">
								<i class="fas" 
									v-bind:class="isDoorOpen(doors.doorstatusfrontleft) ? 'fa-door-open' : 'fa-door-closed'"
									:title="doors.doorstatusfrontleft.value">
								</i>
							</div>
						</div>
					</div>

					<div class="card-footer">
						<i class="fas fa-info-circle"></i>
						Updated At: <b>{{ getUpdatedDate(doors.doorlockstatusfrontleft.timestamp) }}</b> 
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-sm-2">
								<i class="fas" 
									v-bind:class="isDoorLocked(doors.doorlockstatusfrontright) ? 'fa-lock' : 'fa-lock-open'"
									:title="doors.doorlockstatusfrontright.value">
								</i>
							</div>

							<div class="col-sm-7 text-center">
								Front Right
							</div>

							<div class="col-sm-2">
								<i class="fas" 
									v-bind:class="isDoorOpen(doors.doorstatusfrontright) ? 'fa-door-open' : 'fa-door-closed'"
									:title="doors.doorstatusfrontright.value">
								</i>
							</div>
						</div>
					</div>

					<div class="card-footer">
						<i class="fas fa-info-circle"></i>
						Updated At: <b>{{ getUpdatedDate(doors.doorlockstatusfrontright.timestamp) }}</b> 
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-sm-2">
								<i class="fas" 
									v-bind:class="isDoorLocked(doors.doorlockstatusrearleft) ? 'fa-lock' : 'fa-lock-open'"
									:title="doors.doorlockstatusrearleft.value">
								</i>
							</div>

							<div class="col-sm-7 text-center">
								Rear Left
							</div>

							<div class="col-sm-2">
								<i class="fas" 
									v-bind:class="isDoorOpen(doors.doorstatusrearright) ? 'fa-door-open' : 'fa-door-closed'"
									:title="doors.doorstatusrearleft.value">
								</i>
							</div>
						</div>
					</div>

					<div class="card-footer">
						<i class="fas fa-info-circle"></i>
						Updated At: <b>{{ getUpdatedDate(doors.doorlockstatusrearleft.timestamp) }}</b> 
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-sm-2">
								<i class="fas" 
									v-bind:class="isDoorLocked(doors.doorlockstatusrearright) ? 'fa-lock' : 'fa-lock-open'"
									:title="doors.doorlockstatusrearright.value">
								</i>
							</div>

							<div class="col-sm-7 text-center">
								Rear Right
							</div>

							<div class="col-sm-2">
								<i class="fas" 
									v-bind:class="isDoorOpen(doors.doorstatusrearright) ? 'fa-door-open' : 'fa-door-closed'"
									:title="doors.doorstatusrearright.value">
								</i>
							</div>
						</div>
					</div>

					<div class="card-footer">
						<i class="fas fa-info-circle"></i>
						Updated At: <b>{{ getUpdatedDate(doors.doorlockstatusrearright.timestamp) }}</b> 
					</div>
				</div>
			</div>
		</div>

		<div class="pt-4">
			<div class="text-center border-top pt-4" v-if="doors">
				<button v-on:click="lockDoors()" class="btn btn-secondary">{{ isVehicleLocked() ? 'Unlock' : 'Lock' }}</button>
			</div>
		</div>
	</div>
</template>

<script>

var vehiclesApiURI = "/vehicles/";
var doorsApiURI = "/doors/";

import axios from 'axios';
import moment from 'moment';

export default {
	name: 'app',
	components: {},
	data() {
		return {
			vehicleId : null,
			doors: null
		}
	},

	methods: {
		getUpdatedDate : function( timestamp ) {
			return moment.unix(timestamp).format('DD:MM:YYYY');
		},

		isDoorLocked : function( doorStatus ) {
			return doorStatus.value == 'LOCKED';
		},

		isDoorOpen : function( doorStatus ) {
			return doorStatus.value == 'OPEN';
		},

		getVehicle: function() {
			axios
			.get(vehiclesApiURI)
			.then(response => {
				this.vehicleId = response.data[0].id;
				this.getDoors();
				this.interval = setInterval(() => {
					this.getDoors()
				}, 4000);
			})
			.catch(error => {
				console.log(error);
			})
		},

		getDoors: function() {
			axios
			.get(doorsApiURI + this.vehicleId)
			.then(response => {
				this.doors = response.data;
			})
			.catch(error => {
				console.log(error);
			})
		},

		lockDoors : function() {
			axios
			.post(doorsApiURI + this.vehicleId,
			{
				command: this.isVehicleLocked() ? 'UNLOCK' : 'LOCK'
			}
			)
			.then(response => {
				console.log(response);
			})
			.catch(error => {
				console.log(error);
			})

			this.getDoors();
		},
		
		isVehicleLocked : function() {
			return this.doors.doorlockstatusvehicle.value === 'LOCKED';
		}
	},

	mounted() {
		this.getVehicle();
	}

}
</script>

<style>

	@import url('https://fonts.googleapis.com/css?family=Raleway');

	@import url('https://use.fontawesome.com/releases/v5.2.0/css/all.css');

	body {
		background: #EEF1F4 !important;
		font-family: 'Raleway', sans-serif !important;
	}

	.container {
		max-width: 1000px !important;
	}

	.card {
		box-shadow: 0 6px 10px -4px rgba(0,0,0,.15);
		border-radius: 6px;
	}

	.fa-info-circle {
		color: #a9a9a9;
		width: 20px;
	}
	
	.card-footer {
		font-size: 13px;
	}

</style>
