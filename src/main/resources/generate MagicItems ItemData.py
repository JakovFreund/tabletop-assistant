import json

file_path = '5e-SRD-Magic-Items.json' #thanks to https://github.com/5e-bits/5e-database
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


imports = ["java.util.List","java.util.Map","static java.util.Map.entry","com.freund.tabletop_assistant.model.item.armour.Armour","com.freund.tabletop_assistant.model.damage.DamageType", "com.freund.tabletop_assistant.model.item.weapon.Weapon", "com.freund.tabletop_assistant.model.item.weapon.WeaponAttributes", "com.freund.tabletop_assistant.model.item.weapon.WeaponCategory", "com.freund.tabletop_assistant.model.item.weapon.WeaponProperty", "com.freund.tabletop_assistant.model.item.weapon.WeaponRange", "com.freund.tabletop_assistant.model.item.weapon.WeaponRangeType"]

with open(file_path, 'r') as f:
    data = json.load(f)

with open(output_file, 'w') as f:
    f.write("package "+package+";\n\n")
    for imp in imports:
        f.write("import "+imp+";\n")
    f.write("\n// @formatter:off\npublic final class "+java_class_name)
    f.write(" {\n\tpublic static final List<Item> ITEMS = List.of(\n")

    for item_index, item in enumerate(data):
        names = []
        if item["variants"]:
            for variant in item["variants"]:
                names.append(variant["name"])
        else:
            names.append(item["name"])
        for name in names:
            c = item["equipment_category"]["index"]
            if c=="mounts-and-vehicles":
                print("mount or vehicle skipped: "+name)
                continue

            weapons = ["weapon","staff","rod","wand"]
            
            f.write("\t\tnew ")
            if c in weapons:
                f.write("Weapon(")
            elif c=="armor":
                f.write("Armour(")
            else:
                f.write("Item(")
            

            f.write("\""+name+"\", ")
            f.write("null, ") #img

            # Category
            if not (c in weapons or c=="armor"):
                f.write("ItemCategory.")

                if c in ["ammunition", "ring", "potion", "scroll"]:
                    f.write(c.upper())
                elif c=="wondrous-items":
                    f.write("WONDROUS_ARTIFACT")

                f.write(", ")


            rarity = item["rarity"]["name"]
            f.write("Rarity."+rarity.upper().replace(" ","_")+", ")
            rarity_price = {"Varies": 0, "Common":15000, "Uncommon":50000, "Rare":250000, "Very Rare":500000, "Legendary":1000000, "Artifact":2000000}
            f.write(str(rarity_price[rarity])+", ")

            f.write("0, ") # weight

            ### LEFT HERE
                
            f.write("true, List.of(), List.of(")
            if "desc" in item.keys():
                for i, text in enumerate(item["desc"]):
                    f.write("\""+text+"\"")
                    if i < len(item["desc"])-1:
                        f.write(", ")
            f.write(")")

    # new WeaponAttributes(WeaponCategory.SIMPLE,
    # new WeaponRange(WeaponRangeType.MELEE, 10, 20), List.of(WeaponProperty.FINESSE)),
    # Map.ofEntries(entry(DamageType.BLUDGEONING, "1d5")))

            if c in weapons:
                if c in ["staff","rod","wand"]:
                    f.write(", new WeaponAttributes(WeaponType."+c.upper())
                else:
                    f.write(", new WeaponAttributes(WeaponCategory.") #
                    f.write("SIMPLE")
                    f.write(", new WeaponRange(WeaponRangeType.")
                    f.write("MELEE")
                    f.write(", 0") #range
                    f.write(", 0") #throw_range
                    f.write("), List.of()") #properties
                f.write("), Map.ofEntries()")
            elif c=="armor":
                f.write(", ArmourCategory.LIGHT")
                f.write(", new ItemArmourClass(")
                f.write(str(0)) #base AC
                f.write(", false") # dexBonus
                f.write(", -1") #maxBonus
                f.write("), ")
                f.write("false, ") #stealthDisadvantage
                f.write("0") #minimumStrength

            f.write("),\n")
        
        

    

    f.write("\t\t);\n\n\tprivate "+java_class_name+"() { // Private constructor to prevent instantiation\n\t\t")
    f.write("throw new UnsupportedOperationException(\"This is a utility class and cannot be instantiated\");\n\t}\n}")

print("Items written.")
