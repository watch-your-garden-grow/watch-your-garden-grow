var planIdent;

const addPlantToPlan = async (plantId) => {
    if (!planIdent) await getNewPlan()
    console.log("Adding Plant "+plantId+" to Plan Id: " +planIdent)
    await putFetch("/api/plantplan/" + planIdent + "/plant/" + plantId)
}

const putFetch = (url) => fetch(url, {method: 'PUT'})

const getNewPlan = () => fetch("/api/plantplan").then(res => res.json()).then(resJson => planIdent = resJson.id)
