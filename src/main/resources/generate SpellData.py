import json

file_path = '5e-SRD-Spells.json' #thanks to https://github.com/5e-bits/5e-database
java_class_name = "SpellData"
output_file = java_class_name+".java"
#output_file = java_class_name+".txt"


with open(file_path, 'r') as f:
    data = json.load(f)

with open(output_file, 'w') as f:
    f.write("package com.freund.tabletop_assistant.model;\n\n")
    f.write("import java.util.List;\nimport java.util.Map;\nimport static java.util.Map.entry;")
    f.write("\n\n// @formatter:off\npublic final class "+java_class_name)
    f.write(" {\n\tpublic static final List<Spell> SPELLS = List.of(\n")

    for spell_index, spell in enumerate(data):
        f.write("\t\tnew Spell(")
        f.write("\""+spell["name"]+"\", ")
        f.write(str(spell["level"])+", ")
        f.write("SchoolOfMagic."+spell["school"]["index"].upper()+", ")
        f.write(str(spell["ritual"]).lower()+", ")
        f.write(str(spell["concentration"]).lower()+", ")
        if "higher_level" in spell.keys():
            f.write("true, ")
        else:
            f.write("false, ")
        if "dc" in spell.keys():
            f.write("Ability."+spell["dc"]["dc_type"]["name"]+", ")
        else:
            f.write("Ability.NONE, ")

        #EffectTarget
        f.write("new EffectTarget(")
        if spell["range"]=="1 mile":
            f.write("RangeType.RANGE, 5000")
        elif spell["range"]=="90 feet":
            f.write("RangeType.RANGE, 90")
        elif spell["range"]=="100 feet":
            f.write("RangeType.RANGE, 100")
        elif spell["range"]=="Unlimited":
            f.write("RangeType.UNLIMITED, 0")
        elif spell["range"]=="120 feet":
            f.write("RangeType.RANGE, 120")
        elif spell["range"]=="30 feet":
            f.write("RangeType.RANGE, 30")
        elif spell["range"]=="Touch":
            f.write("RangeType.TOUCH, 0")
        elif spell["range"]=="300 feet":
            f.write("RangeType.RANGE, 300")
        elif spell["range"]=="Special":
            f.write("RangeType.SPECIAL, 0")
        elif spell["range"]=="500 miles":
            f.write("RangeType.RANGE, 2500000")
        elif spell["range"]=="10 feet":
            f.write("RangeType.RANGE, 10")
        elif spell["range"]=="Sight":
            f.write("RangeType.SIGHT, 0")
        elif spell["range"]=="Self":
            f.write("RangeType.SELF, 0")
        elif spell["range"]=="5 feet":
            f.write("RangeType.RANGE, 5")
        elif spell["range"]=="150 feet":
            f.write("RangeType.RANGE, 150")
        elif spell["range"]=="500 feet":
            f.write("RangeType.RANGE, 500")
        elif spell["range"]=="60 feet":
            f.write("RangeType.RANGE, 60")

        if "area_of_effect" in spell.keys():
            f.write(", AreaType."+spell["area_of_effect"]["type"].upper()+", "+str(spell["area_of_effect"]["size"]))
        f.write("), ")
            
        #Duration
        f.write("new Duration(DurationType.")
        if spell["duration"]=="24 hours" or spell["duration"]=="Up to 24 hours":
            f.write("TURNS, 14400")
        elif spell["duration"]=="1 round" or spell["duration"]=="Up to 1 round":
            f.write("TURNS, 1") #or 2?
        elif spell["duration"]=="Special":
            f.write("SPECIAL, 0")
        elif spell["duration"]=="7 days":
            f.write("TURNS, 100800")
        elif spell["duration"]=="Until dispelled":
            f.write("FOREVER, 0")
        elif spell["duration"]=="1 hour" or spell["duration"]=="Up to 1 hour":
            f.write("TURNS, 600")
        elif spell["duration"]=="8 hours" or spell["duration"]=="Up to 8 hours":
            f.write("TURNS, 4800")
        elif spell["duration"]=="Instantaneous":
            f.write("INSTANT, 0")
        elif spell["duration"]=="1 minute" or spell["duration"]=="Up to 1 minute":
            f.write("TURNS, 10")
        elif spell["duration"]=="10 minutes":
            f.write("TURNS, 100")
        elif spell["duration"]=="Up to 2 hours":
            f.write("TURNS, 1200")
        elif spell["duration"]=="30 days":
            f.write("TURNS, 432000")
        else:
            f.write("SPECIAL, 0")
        f.write("), ")

        #HashMap<TurnResourceType, Integer> costs; // casting_time
        f.write("Map.ofEntries(")
        if spell["casting_time"]=="12 hours":
            f.write("entry(TurnResourceType.ACTION, 7200)")
        elif spell["casting_time"]=="1 minute":
            f.write("entry(TurnResourceType.ACTION, 10)")
        elif spell["casting_time"]=="24 hours":
            f.write("entry(TurnResourceType.ACTION, 14400)")
        elif spell["casting_time"]=="1 bonus action":
            f.write("entry(TurnResourceType.BONUS_ACTION, 1)")
        elif spell["casting_time"]=="1 hour":
            f.write("entry(TurnResourceType.ACTION, 600)")
        elif spell["casting_time"]=="10 minutes":
            f.write("entry(TurnResourceType.ACTION, 100)")
        elif spell["casting_time"]=="8 hours":
            f.write("entry(TurnResourceType.ACTION, 4800)")
        elif spell["casting_time"]=="1 action":
            f.write("entry(TurnResourceType.ACTION, 1)")
        elif spell["casting_time"]=="1 reaction":
            f.write("entry(TurnResourceType.REACTION, 1)")
        f.write("), ")
        
        #List<CastableDamageComponent> castableDamageComponents;
        f.write("List.of(")
        if "damage" in spell.keys():
            f.write("new CastableDamageComponent(")
            if "damage_type" not in spell["damage"].keys():
                f.write("null")
            else:
                f.write("DamageType."+spell["damage"]["damage_type"]["index"].upper())

            #Map<Integer, String> damageAtCreatureLevel;
            f.write(", Map.ofEntries(")
            if "damage_at_character_level" in spell["damage"].keys():
                damage_at_character_level_length=len(spell["damage"]["damage_at_character_level"])
                for level, damage in spell["damage"]["damage_at_character_level"].items():
                    f.write("entry("+level+", \""+damage+"\")")
                    damage_at_character_level_length-=1
                    if damage_at_character_level_length>0:
                        f.write(", ")

            #Map<Integer, String> damageAtSlotLevel;
            f.write("), Map.ofEntries(")
            if "damage_at_slot_level" in spell["damage"].keys():
                damage_at_slot_level_length=len(spell["damage"]["damage_at_slot_level"])
                for level, damage in spell["damage"]["damage_at_slot_level"].items():
                    f.write("entry("+level+", \""+damage+"\")")
                    damage_at_slot_level_length-=1
                    if damage_at_slot_level_length>0:
                        f.write(", ")
            f.write("))")
        
        #HashMap<Integer, String> healAtSlotLevel;
        f.write("), Map.ofEntries(")
        if "heal_at_slot_level" in spell.keys():
            heal_at_slot_level_length=len(spell["heal_at_slot_level"])
            for level, heal in spell["heal_at_slot_level"].items():
                f.write("entry("+level+", \""+heal+"\")")
                heal_at_slot_level_length-=1
                if heal_at_slot_level_length>0:
                    f.write(", ")
        f.write("), ")

        #List<StatusEffect> statusEffects;
        f.write("List.of(), ")

        #List<String> description;
        f.write("List.of(")
        for i, desc in enumerate(spell["desc"]):
            f.write("\""+desc.replace("\"","\\\"")+"\"")
            if i<len(spell["desc"])-1:
                f.write(", ")
        f.write("), ")


        #List<String> descriptionAtHigherLevel;
        f.write("List.of(")
        if "higher_level" in spell.keys():
            for i, desc in enumerate(spell["higher_level"]):
                f.write("\""+desc.replace("\"","\\\"")+"\"")
                if i<len(spell["higher_level"])-1:
                    f.write(", ")
        f.write(")")

        
        if spell_index<len(data)-1:
            f.write("),\n")
        else:
            f.write(")\n")

    

    f.write("\t\t);\n\n\tprivate "+java_class_name+"() { // Private constructor to prevent instantiation\n\t\t")
    f.write("throw new UnsupportedOperationException(\"This is a utility class and cannot be instantiated\");\n\t}\n}")

print("Spells written.")
