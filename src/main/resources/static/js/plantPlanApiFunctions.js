let planIdent;

const addPlantToPlan = async (plantId) => {
    if (!planIdent) await getNewPlan()
    console.log("Adding Plant " + plantId + " to Plan Id: " + planIdent)
    await putFetch("/api/plantplan/" + planIdent + "/plant/" + plantId)
}

const removePlantFromPlan = async (plantId) => {
    console.log("Removing Plant " + plantId + " from Plan Id: " + planIdent)
    await deleteFetch("/api/plantplan/" + planIdent + "/plant/" + plantId)
}

const putFetch = (url) => fetch(url, {method: 'PUT'})

const deleteFetch = (url) => fetch(url, {method: 'DELETE'})

const getNewPlan = () => fetch("/api/plantplan").then(res => res.json()).then(resJson => planIdent = resJson.id)
