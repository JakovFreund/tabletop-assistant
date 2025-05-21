import json

file_path = '5e-SRD-Equipment.json' #thanks to https://github.com/5e-bits/5e-database
java_class_name = "ItemData"
package = "com.freund.tabletop_assistant.model.item"
#output_file = java_class_name+".java"
output_file = java_class_name+".txt"


# new Item("name", "img", ItemCategory.RING, Rarity.COMMON,
# 10(cost), 12.0f(weight), false(needsIdentify), List.of(), List.of("desc"))

# new Weapon("name", "img", Rarity.COMMON, 0, 0, false, List.of(),
# List.of("desc"), new WeaponAttributes(WeaponCategory.SIMPLE,
# new WeaponRange(WeaponRangeType.MELEE, 10, 20), List.of(WeaponProperty.FINESSE)),
# Map.ofEntries(entry(DamageType.BLUDGEONING, "1d5")))


imports = ["java.util.List","java.util.Map","static java.util.Map.entry","com.freund.tabletop_assistant.model.item.armour.Armour","com.freund.tabletop_assistant.model.item.armour.ArmourCategory","com.freund.tabletop_assistant.model.item.armour.ItemArmourClass","com.freund.tabletop_assistant.model.damage.DamageType", "com.freund.tabletop_assistant.model.item.weapon.Weapon", "com.freund.tabletop_assistant.model.item.weapon.WeaponAttributes", "com.freund.tabletop_assistant.model.item.weapon.WeaponCategory", "com.freund.tabletop_assistant.model.item.weapon.WeaponProperty", "com.freund.tabletop_assistant.model.item.weapon.WeaponRange", "com.freund.tabletop_assistant.model.item.weapon.WeaponRangeType"]

with open(file_path, 'r') as f:
    data = json.load(f)

with open(output_file, 'w') as f:
    f.write("package "+package+";\n\n")
    for imp in imports:
        f.write("import "+imp+";\n")
    f.write("\n// @formatter:off\npublic final class "+java_class_name)
    f.write(" {\n\tpublic static final List<Item> ITEMS = List.of(\n")

    for item_index, item in enumerate(data):
        c = item["equipment_category"]["index"]
        if c=="mounts-and-vehicles":
            print("mount or vehicle skipped: "+item["name"])
            continue
        if "contents" in item.keys():
            print("container skipped: "+item["name"])
            continue


        f.write("\t\tnew ")
        if c=="weapon":
            f.write("Weapon(")
        elif c=="armor":
            f.write("Armour(")
        else:
            f.write("Item(")
        

        f.write("\""+item["name"]+"\", ")
        f.write("null, ") #img

        # Category
        if not (c=="weapon" or c=="armor"):
            f.write("ItemCategory.")

            if c=="adventuring-gear":
                c2 = item["gear_category"]["index"]
                # 'ammunition', 'equipment-packs', 'druidic-foci', 'standard-gear', 'holy-symbols', 'kits', 'arcane-foci'
                if c2=="ammunition":
                    f.write("AMMUNITION")
                else:
                    f.write("GEAR_AND_TOOLS")
            elif c=="tools":
                c2 = item["tool_category"]
                #"Artisan's Tools", 'Musical Instrument', 'Other Tools', 'Gaming Sets'
                f.write("GEAR_AND_TOOLS")


            f.write(", ")

        f.write("Rarity.COMMON, ") #always common for equipment

        unit = {"cp":1, "sp":10, "gp":100}[item["cost"]["unit"]]
        f.write(str(item["cost"]["quantity"]*unit)+", ")

        if "weight" in item.keys():
            f.write(str(item["weight"])+"f, ")
        else:
            print(item["name"]+" no weight")
            f.write("0, ")
        f.write("false, List.of(), List.of(")
        if "special" in item.keys():
            for i, text in enumerate(item["special"]):
                f.write("\""+text+"\"")
                if i < len(item["special"])-1 or "desc" in item.keys():
                    f.write(", ")
        if "desc" in item.keys():
            for i, text in enumerate(item["desc"]):
                f.write("\""+text+"\"")
                if i < len(item["desc"])-1:
                    f.write(", ")
        f.write(")")

# new WeaponAttributes(WeaponCategory.SIMPLE,
# new WeaponRange(WeaponRangeType.MELEE, 10, 20), List.of(WeaponProperty.FINESSE)),
# Map.ofEntries(entry(DamageType.BLUDGEONING, "1d5")))

        if c=="weapon":
            f.write(", new WeaponAttributes(WeaponCategory.") #
            f.write(item["weapon_category"].upper())
            f.write(", new WeaponRange(WeaponRangeType.")
            f.write(item["weapon_range"].upper())
            f.write(", "+str(item["range"]["normal"]))
            if "throw_range" in item.keys():
                f.write(", "+str(item["throw_range"]["normal"]))
            else:
                f.write(", 0")
            f.write("), List.of(")
            for i, prop in enumerate(item["properties"]):
                f.write("WeaponProperty."+prop["index"].upper().replace("-","_"))
                if i < len(item["properties"])-1:
                    f.write(", ")
            f.write(")), Map.ofEntries(")
            if "damage" in item.keys():
                for i, damage in enumerate(item["damage"]):
                    f.write("entry(DamageType."+item["damage"]["damage_type"]["index"].upper())
                    f.write(", \""+item["damage"]["damage_dice"]+"\")")
                    if i < len(item["damage"])-1:
                        f.write(", ")
            f.write(")")
        elif c=="armor":
            f.write(", ArmourCategory.")
            f.write(item["armor_category"].upper())
            f.write(", new ItemArmourClass(")
            f.write(str(item["armor_class"]["base"]))
            f.write(", "+str(item["armor_class"]["dex_bonus"]).lower())
            if "max_bonus" in item["armor_class"].keys():
                f.write(", "+str(item["armor_class"]["max_bonus"]))
            else:
                f.write(", -1")
            f.write("), ")
            f.write(str(item["stealth_disadvantage"]).lower()+", ")
            f.write(str(item["str_minimum"]))



        f.write("),\n")
        
        

    

    f.write("\t\t);\n\n\tprivate "+java_class_name+"() { // Private constructor to prevent instantiation\n\t\t")
    f.write("throw new UnsupportedOperationException(\"This is a utility class and cannot be instantiated\");\n\t}\n}")

print("Items written.")
