
USE agenda;

SELECT agenda.personas.`CP`,
	agenda.personas.`Nombre`,
	agenda.personas.`Telefono`
FROM agenda.personas
group by agenda.personas.`CP`, agenda.personas.`Nombre`
ORDER BY agenda.personas.`CP` ASC




