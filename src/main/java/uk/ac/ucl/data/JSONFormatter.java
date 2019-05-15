package uk.ac.ucl.data;

public class JSONFormatter
{
    public StringBuilder writeSingleJSON(String ID, ReadCSV reader)
    {
        StringBuilder sb = new StringBuilder("{\n\"Patient Information\":[\n");
        for(Patient patients: reader.getPatientList())
        {
            if(patients.getID().compareTo(ID) == 0)
            {
                sb.append("{\n");
                boolean first = true;
                for(String category : patients.getPatientMap().keySet())
                {
                    if(!first){sb.append(",\n");}
                    first = false;
                    sb.append("\"");
                    sb.append(category);
                    sb.append("\"");
                    sb.append(": ");
                    sb.append("\"");
                    sb.append(patients.getPatientMap().get(category));
                    sb.append("\"");
                }
            }
        }
        sb.append("\n}\n]\n}");
        return sb;
    }

    public StringBuilder writeAllJSON(ReadCSV reader) 
    {
        StringBuilder sb = new StringBuilder("{\n\"Patients\": [\n");

        boolean firstcurly = true;
        for(Patient patients: reader.getPatientList())
        {
            if(!firstcurly){sb.append("\n},\n");}
            firstcurly = false;
            sb.append("{\n");

            boolean first = true;
            for(String categories : patients.getPatientMap().keySet())
            {
                if(!first){sb.append(",\n");}
                first = false;
                sb.append("\"");
                sb.append(categories);
                sb.append("\"");
                sb.append(":");
                sb.append("\"");
                sb.append(patients.getPatientMap().get(categories));
                sb.append("\"");
            }
        }
        sb.append("\n}\n]\n}");
        return sb;
    }
}